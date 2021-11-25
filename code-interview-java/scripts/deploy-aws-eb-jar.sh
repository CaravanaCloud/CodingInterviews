#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

echo "Setting variables"
export UNIQ=${UNIQ:-"id42"}
export PACKAGE_FILE="code-interview-java-eb.zip"
export PACKAGE="$DIR/../target/$PACKAGE_FILE"
export EB_VERSION_LABEL="v$(date +%y%m%d%H%M)"
export EB_VERSION_KEY="code-interview-java-eb-$EB_VERSION_LABEL.zip"
export EB_VERSION_URL="s3://$EB_BUCKET/$EB_VERSION_KEY"

echo "UNIQ=$UNIQ"
echo "PACKAGE=$PACKAGE"
echo "EB_BUCKET=$EB_BUCKET"
echo "EB_APP=$EB_APP"
echo "EB_TEMPLATE=$EB_TEMPLATE"
echo "EB_VERSION_LABEL=$EB_VERSION_LABEL"
echo "EB_VERSION_KEY=$EB_VERSION_KEY"
echo "EB_VERSION_URL=$EB_VERSION_URL"

sleep 5

mvn clean package -Peb

ls -liah $PACKAGE

aws s3 cp $PACKAGE $EB_VERSION_URL

aws elasticbeanstalk create-application-version \
    --application-name $EB_APP \
    --version-label $EB_VERSION_LABEL \
    --source-bundle S3Bucket=$EB_BUCKET,S3Key=$EB_VERSION_KEY

export EB_CNAME=$EB_VERSION_LABEL
aws elasticbeanstalk check-dns-availability --cname-prefix $EB_CNAME

echo "Generating options file" 
export EB_INSTANCE_TYPES="t3.large"
export EB_SPOT="false"
rm -f $DIR/options.txt
envsubst < $DIR/options.txt.env > $DIR/options.txt
cat $DIR/options.txt

sleep 5

echo "Creating Environment" 
export EB_ENV="$UNIQ-eb-env-$EB_VERSION_LABEL"
echo "EB_TEMPLATE=$EB_TEMPLATE"
echo "EB_ENV=$EB_ENV"
echo "#"
echo aws elasticbeanstalk create-environment \
    --cname-prefix "$EB_CNAME" \
    --application-name "$EB_APP" \
    --template-name "$EB_TEMPLATE" \
    --version-label "$EB_VERSION_LABEL" \
    --environment-name "$EB_ENV" \
    --output "json" \
    --option-settings "file://$DIR/options.txt"
echo "#"

#    --template-name "$EB_TEMPLATE" \
export EB_STACK_NAME="64bit Amazon Linux 2 v3.2.8 running Corretto 11"
aws elasticbeanstalk create-environment \
    --cname-prefix "$EB_CNAME" \
    --application-name "$EB_APP" \
    --version-label "$EB_VERSION_LABEL" \
    --environment-name "$EB_ENV" \
    --solution-stack-name "$EB_STACK_NAME" \
    --option-settings "file://$DIR/options.txt" \
    --output "json" 

echo "done"
