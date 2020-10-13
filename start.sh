#!/bin/bash
echo "准备启动管理端消息工程"
pid=`ps -ef | grep manage-message-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   kill -9 $pid
   echo "关闭进程："$pid
fi

echo "执行....."
nohup  java -jar /var/lib/jenkins/workspace/manage-project-rest/manage-message/target/manage-message-0.0.1-SNAPSHOT.jar  >> device-temp.txt 2>&1 &

echo "启动成功"

ppid=`ps -ef | grep manage-message-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{print $2}'`
echo "启动pid =$ppid"
echo "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
