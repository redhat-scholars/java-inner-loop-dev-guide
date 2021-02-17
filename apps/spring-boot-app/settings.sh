#!/bin/sh

export GIT_REPO_URL="https://github.com/redhat-scholars/java-inner-loop-dev-guide#main"

export FRUITS_DATABASE_SERVICE_NAME="my-database"
export FRUITS_DATABASE_SERVICE_PORT="5432"
export FRUITS_DATABASE_NAME="my_data"
export FRUITS_DATABASE_USERNAME="luke"
export FRUITS_DATABASE_PASSWORD="secret"

export FRUITS_VERSION=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
export FRUITS_CONTEXT_DIR="."
export FRUITS_SERVICE_NAME="fruit-service"
export FRUITS_IMAGE="${FRUITS_SERVICE_NAME}:${FRUITS_VERSION}"

export JAVA_BUILDER_IMAGE="registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift"
export QUARKUS_IMAGESTREAM="redhat-openjdk-18/openjdk18-openshift"

export USERNAME=cvicensa