#!/bin/bash
cp -ri ./ ~/Programming/Robotics/teamcode/
cd ~/Programming/Robotics/teamcode/
echo "Commit Message: "
read commit
git add *
git commit -m "$commit"
git push origin master