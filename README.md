## Step-1
   Create a user called ansible and setup password. Also provide administrator access.

## Step-2
[install choco in windows ]

`Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))`

## Step-3 
[Install python3 and openssh in your windows server so that ansible can ping windows. Use below cmd to install]

`choco install --package-parameters=/SSHServerFeature openssh`

`choco install python3`


## Step-4
 Install ansible, python3, git and sshpass where your jenkins server is running.

## Step-5
  Install Ansible plugin in jenkins.

## Step-6
  Go to "manage jenkins->Golobal configuration" and Select Ansible section. After this just set name and Path to ansible executables directory.

## Step-7
   Create a pipline script. Make sure that you have put windows user name and password in credential form so that ansible can go to windows and configure further things.

## Step-8
 Create a Pipeline in Jenkins which will run Ansible script.

    pipeline{
    agent any
    stages{
        stage('SCM Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/Sulekha02112001/extrawork_ansible_win_update.git'
            }
        }
        stage('Execute Ansible'){
            steps{
                ansiblePlaybook becomeUser: 'Administrator', credentialsId: '54fdb36a-9a57-4637-9f7b-2aa838f4c302', disableHostKeyChecking: true, installation: 'ansible', inventory: 'hosts.inv', playbook: 'ansible.yml', sudoUser: 'Administrator'
            }
        }
    }
}

## Step-9
   Finally run your job 
