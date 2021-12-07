#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

mvn -f "$DIR/../pom.xml" \
    clean \
    jacoco:prepare-agent \
    test \
    jacoco:report \
    -fn
