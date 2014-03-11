# Instalation Guide #

Fork the repository then do:
```
git clone https://github.com/<username>/Chess-Game
```
After that, open it with Eclipse:
  File/Import.../General/Existing Projects into Workspace

# Saving your work to github #

You can do a lot of stuff 
```
git add .
git commit -m '<comment>'
git push
```

# Sending a pull Request #

After saving your work in your own repository, you need to add it to the main project.
You are doing that by going to: https://github.com/<username>/Chess-Game
and clicking on **Pull Requests** and then **New pull request**

## Creating branches for safely making changes ##

This technique is particularly good when you're trying new things and don't want to mess up a currently working state of the project

 - create a branch `git checkout -v my-branch-name` and work on it ( you can add as many commits as you want )
 - push to that branch `git push origin my-branch-name`
 - send pull request from `<username>:my-branch-name to Chess-Game:develop`

# Rebasing with master branch #

```bash
$ # Add Chess-Game remote if you do not already have it
$ git remote add Chess-Game git@github.com:crushack/Chess-Game.git
$ git stash save # stashes currently unstaged changes
$ git checkout master # change branch to master
$ git pull kuende master # get any new changes from master branch
$ git checkout my-branch-name
$ git rebase master
```

# Rebasing with develop branch #

```bash
$ # Add Chess-Game remote if you do not already have it
$ git remote add Chess-Game git@github.com:crushack/Chess-Game.git
$ git stash save # stashes currently unstaged changes
$ git checkout develop # change branch to develop
$ git pull kuende develop # get any new changes from main develop branch
$ git checkout my-branch-name
$ git rebase develop
```
