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
