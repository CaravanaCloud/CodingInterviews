#!/usr/bin/env sh

for dir in ./*/; do
  pushd $dir
  echo "Building $dir"
  RUN_FILE="./run.sh"
  if [ -f "$RUN_FILE" ]
  then
      echo "# RUNING $dir $RUN_FILE"
      source $RUN_FILE
  else
      echo "# NOT RUNNING $dir $RUN_FILE"
  fi
  popd
done

echo "Done running."