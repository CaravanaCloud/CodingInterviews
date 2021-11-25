#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

echo "Loading unique id"
export UNIQ=${UNIQ:-"id42"}
echo "UNIQ=$UNIQ"

sleep 5

echo "Creating VPC"
export VPC_ID=$(aws ec2 create-vpc \
    --cidr-block 10.0.0.0/16 \
    --query "Vpc.VpcId" \
    --output text)

echo "Creating VPC name tag"
aws ec2 create-tags \
    --resources $VPC_ID \
    --tags Key=Name,Value="vpc-$UNIQ"

echo "Enabling DNS Support"
aws ec2 modify-vpc-attribute \
  --enable-dns-support \
  --vpc-id $VPC_ID

echo "Enabling DNS Hostnames"
aws ec2 modify-vpc-attribute \
  --enable-dns-hostnames \
  --vpc-id $VPC_ID

echo "Provisioning internet gateway"
export IGW_ID=$(aws ec2 create-internet-gateway \
    --query "InternetGateway.InternetGatewayId" \
    --output text)

aws ec2 attach-internet-gateway --vpc-id $VPC_ID --internet-gateway-id $IGW_ID

echo "Provisioning public route table"
export RTB_ID=$(aws ec2 create-route-table \
    --vpc-id $VPC_ID \
    --query "RouteTable.RouteTableId" \
    --output text)

aws ec2 create-route \
    --route-table-id $RTB_ID \
    --destination-cidr-block 0.0.0.0/0 \
    --gateway-id $IGW_ID

echo "Provisioning Public Subnet A in AZ 1"
export AZ1=$(aws ec2 describe-availability-zones \
    --query "AvailabilityZones[0].ZoneName" \
    --output text)

export NET_A=$(aws ec2 create-subnet \
    --vpc-id $VPC_ID \
    --cidr-block 10.0.200.0/24 \
    --availability-zone "$AZ1" \
    --query "Subnet.SubnetId" \
    --output text)

aws ec2 associate-route-table \
    --subnet-id $NET_A \
     --route-table-id $RTB_ID
     
aws ec2 modify-subnet-attribute  \
    --subnet-id $NET_A  \
    --map-public-ip-on-launch

echo "Provisioning Public Subnet B in AZ 2"
export AZ2=$(aws ec2 describe-availability-zones \
    --query "AvailabilityZones[1].ZoneName" \
    --output text)

export NET_B=$(aws ec2 create-subnet \
    --vpc-id $VPC_ID \
    --cidr-block 10.0.201.0/24 \
    --availability-zone "$AZ2" \
    --query "Subnet.SubnetId" \
    --output text)

aws ec2 associate-route-table \
    --subnet-id $NET_B \
     --route-table-id $RTB_ID
     
aws ec2 modify-subnet-attribute  \
    --subnet-id $NET_B  \
    --map-public-ip-on-launch

echo "# Generated IDs"

echo "export UNIQ=$UNIQ"
echo "export VPC_ID=$VPC_ID"
echo "export IGW_ID=$IGW_ID"
echo "export RTB_ID=$RTB_ID"
echo "export AZ1=$AZ1"    
echo "export NET_A=$NET_A"
echo "export AZ2=$AZ2"    
echo "export NET_B=$NET_B"

# echo "done"
