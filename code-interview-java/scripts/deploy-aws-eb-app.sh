#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

export UNIQ=${UNIQ:-"id42"}
echo "UNIQ=$UNIQ"
echo "DIR=$DIR"

sleep 5

echo "Creating Application Bucket"
export EB_BUCKET="$UNIQ-eb-bucket"
aws s3 mb s3://$EB_BUCKET

echo "Creating Elastic Beanstalk Application"
export EB_APP="$UNIQ-eb-uberjar"
aws elasticbeanstalk create-application --application-name $EB_APP

echo "Creating Elastic Beanstalk Role"
export EB_ROLE="$UNIQ-eb-role"
export ROLE_POLICY_DOCUMENT="file://$DIR/eb-ip-trust.json"
echo aws iam create-role --role-name $EB_ROLE --assume-role-policy-document "$ROLE_POLICY_DOCUMENT"
aws iam create-role --role-name $EB_ROLE --assume-role-policy-document "$ROLE_POLICY_DOCUMENT"

echo "Creating Elastic Beanstalk Role Policy"
export EB_POLICY="$UNIQ-eb-policy"
export POLICY_DOCUMENT="file://$DIR/eb-ip-policy.json"
aws iam put-role-policy --role-name $EB_ROLE --policy-name $EB_POLICY --policy-document "$POLICY_DOCUMENT"


echo "Provisioning Instance Profile"
export EB_PROFILE="$UNIQ-eb-profile"
aws iam create-instance-profile --instance-profile-name $EB_PROFILE

aws iam add-role-to-instance-profile \
    --instance-profile-name $EB_PROFILE \
    --role-name $EB_ROLE

echo "Creating ELastic Beanstalk UBERJAR template"
export EB_TEMPLATE="$UNIQ-eb-uberjar-template"
export EB_STACK_NAME="64bit Amazon Linux 2 v3.2.8 running Corretto 11"
aws elasticbeanstalk create-configuration-template \
    --application-name "$EB_APP" \
    --template-name "$EB_TEMPLATE" \
    --solution-stack-name "$EB_STACK_NAME"

echo "# Variables"
echo "export EB_BUCKET=$EB_BUCKET"
echo "export EB_APP=$EB_APP"
echo "export EB_ROLE=$EB_ROLE"
echo "export ROLE_POLICY_DOCUMENT=$ROLE_POLICY_DOCUMENT"
echo "export EB_POLICY=$EB_POLICY"
echo "export POLICY_DOCUMENT=$POLICY_DOCUMENT"
echo "export EB_PROFILE=$EB_PROFILE"
echo "export EB_TEMPLATE=$EB_TEMPLATE"
echo "export EB_STACK_NAME=\"$EB_STACK_NAME\""
echo "# done"
