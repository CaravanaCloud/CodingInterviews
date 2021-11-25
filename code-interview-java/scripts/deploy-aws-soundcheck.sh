#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

echo "Loading variables"
export UNIQ=${UNIQ:-"id42"}

sleep 5

# check AWS Authentication
aws sts get-caller-identity

echo "# Generated IDs"
echo "export UNIQ=$UNIQ"
echo "# done"
