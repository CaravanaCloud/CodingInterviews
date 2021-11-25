#!

# Unique ID

export UNIQ=${UNIQ_ID:-"id42"}
echo "UNIQ=$UNIQ"

# RDS Params

export RDS_NETGRP="$UNIQ-netgrp"
export RDS_NAME="$UNIQ-rds"
export RDS_ROOT_USER="root"
export RDS_ROOT_PASSWORD="Masterkey$UNIQ"
export RDS_PORT="3306"
export RDS_CIDR="0.0.0.0/0"
export RDS_DB="${UNIQ}db"
export RDS_STORAGE="20"
export RDS_INSTANCE_CLASS="db.t3.large"
export RDS_ENGINE="mysql"
export RDS_ENGINE_VERSION="5.7"

# RDS Networking

export RDS_SECG=$(aws ec2 create-security-group \
  --group-name telemo-rds-secgrp \
  --description "telemo-rds-secg" \
  --vpc-id $VPC_ID \
  --query "GroupId" \
  --output text)

echo export RDS_SECG=$RDS_SECG

export RDS_SECG_ID=$(aws ec2 describe-security-groups \
  --filter Name=vpc-id,Values=$VPC_ID Name=group-name,Values=telemo-rds-secgrp \
  --query 'SecurityGroups[*].[GroupId]' \
  --output text)
    
echo export RDS_SECG_ID=$RDS_SECG_ID
	
aws ec2 authorize-security-group-ingress \
  --group-id $RDS_SECG \
  --protocol tcp \
  --port $RDS_PORT \
  --cidr $RDS_CIDR

aws rds create-db-subnet-group \
    --db-subnet-group-name $RDS_NETGRP \
    --db-subnet-group-description "RDS Subnet Group" \
    --subnet-ids $NET_A $NET_B

# RDS    

export RDS_ID=$(aws rds create-db-instance \
  --db-name $RDS_DB  \
  --db-instance-identifier $RDS_NAME \
  --allocated-storage $RDS_STORAGE \
  --db-instance-class $RDS_INSTANCE_CLASS \
  --engine $RDS_ENGINE \
  --engine-version $RDS_ENGINE_VERSION \
  --master-username $RDS_ROOT_USER \
  --master-user-password $RDS_ROOT_PASSWORD \
  --db-subnet-group-name  $RDS_NETGRP \
  --backup-retention-period 0 \
  --publicly-accessible \
  --vpc-security-group-ids $RDS_SECG \
  --query "DBInstance.DBInstanceIdentifier" \
  --output text)

echo "RDS_ID=$RDS_ID"

aws rds wait db-instance-available --db-instance-identifier $RDS_ID

export RDS_ENDPOINT=$(aws rds describe-db-instances  \
  --db-instance-identifier $RDS_ID  \
  --query "DBInstances[0].Endpoint.Address"  \
  --output text)
  
export RDS_PORT=$(aws rds describe-db-instances  \
  --db-instance-identifier $RDS_ID  \
  --query "DBInstances[0].Endpoint.Port"\
  --output text)

export RDS_JDBC=jdbc:mysql://$RDS_ENDPOINT:$RDS_PORT/$MYSQL_DB
echo "RDS_JDBC=$RDS_JDBC"

# echo "mysql -h$RDS_ENDPOINT -u$RDS_ROOT_USER -p$RDS_ROOT_PASSWORD $RDS_DB"  

