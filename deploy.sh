#!/usr/bin/env bash

scp bots-runner/target/personal-bots.jar Stanislau_Kaladziuk@epam.com@ecsc00a0116d.epam.com:/var/apps/personal-bots
ssh Stanislau_Kaladziuk@epam.com@ecsc00a0116d.epam.com sudo systemctl restart personal-bots
