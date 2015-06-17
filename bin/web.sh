#!/bin/sh

# reference
# http://qiita.com/uzresk/items/31a4585f7828c4a9334f

APP_NAME=spring-boot-sample
BASE_DIR=/home/ec2-user/${APP_NAME}
JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk
JAR_FILE=${BASE_DIR}/cmp-web-spring-0.0.1-SNAPSHOT.jar
PID=${BASE_DIR}/${APP_NAME}.pid

case "$1" in
  "start" )
    if [ ! -f ${PID} ]; then
      echo "Starting ${APP_NAME}"
      $JAVA_HOME/bin/java -jar ${JAR_FILE} &
      echo $! > ${PID}
    else
      echo "${APP_NAME} is Running."
    fi
    ;;
  "stop" )
    echo "Stopping ${APP_NAME}"
    kill `cat ${PID}`
    RETVAL=$?
    if test ${RETVAL} -eq 0 ; then
        rm -f ${PID}
    fi
    ;;
  "removepid" )
    rm -f ${PID}
    ;;
  *)
    echo "Usage: web.sh {start|stop|removepid}"
    exit 1
esac