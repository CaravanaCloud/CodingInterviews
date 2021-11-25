#!

export LAMBDA_ROLE="$UNIQ-lambda-role"
aws iam create-role \
    --role-name $LAMBDA_ROLE \
    --assume-role-policy-document file://lambda-role-trust.json

aws iam put-role-policy \
    --role-name $LAMBDA_ROLE \
    --policy-name AllowAPIs \
    --policy-document file://lambda-role-policy.json

mvn clean package -Dnative -Dquarkus.native.container-build=true

cat target/sam.jvm.yaml

export SAM_JVM_STACK="id42"
# https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html
sam deploy --guided -t target/sam.jvm.yaml 

export LAMBDA_JVM=$(aws cloudformation describe-stack-resources \
    --stack-name $SAM_JVM_STACK \
    --logical-resource-id CodeInterviewJava \
    --query "StackResources[0].PhysicalResourceId" \
    --output text) 

echo LAMBDA_NAME=$LAMBDA_NAME

aws lambda update-function-configuration \
    --function-name $LAMBDA_NAME \
    --memory-size 8192 \
    --timeout 900 \
    --environment "Variables={\
        HELLO=WORLD}" \
    --output json 
    
