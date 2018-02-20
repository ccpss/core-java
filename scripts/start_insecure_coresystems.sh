#!/bin/bash

cd ..

echo Starting Core Systems - wait 1 minute
#More sleep time between core systems might be needed on slower devices like a Raspberry Pi

cd serviceregistry_sql/target
rm nohup.out
nohup java -jar serviceregistry_sql-M3.jar -d -daemon -m insecure &
echo Service Registry started
sleep 10s

cd ../../authorization/target
rm nohup.out
nohup java -jar authorization-M3.jar -d -daemon -m insecure &
echo Authorization started
sleep 10s

cd ../../gateway/target
rm nohup.out
nohup java -jar gateway-M3.jar -d -daemon -m insecure &
echo Gateway started
sleep 10s

cd ../../gatekeeper/target
rm nohup.out
nohup java -jar gatekeeper-M3.jar -d -daemon -m insecure &
echo Gatekeeper started
sleep 10s

cd ../../orchestrator/target
rm nohup.out
nohup java -jar orchestrator-M3.jar -d -daemon -m insecure &
echo Orchestrator started
sleep 10s
