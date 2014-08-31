package app;

import java.util.ArrayList;

public class GitInfo {
    private String gitPath;
    
    public GitInfo(String gitPath) {
        this.gitPath = gitPath;
    }
    
    public ArrayList<String> getLastCommits() {
        try {
            return ShellCommand.exec("git --git-dir="+getGitPath()+"/.git --work-tree="+getGitPath()+" log --oneline");
        } catch (Exception ex) {}
        return new ArrayList<String>();
    }
    
    public int numOfCommits() {
        try{
            return Integer.parseInt(ShellCommand.exec("git --git-dir="+getGitPath()+"/.git --work-tree="+getGitPath()+" rev-list HEAD --count").get(0));
        }catch (Exception ex) {}
        return 0;
    }
    
    public String currentBranch() {
        try{
            return ShellCommand.exec("git --git-dir="+getGitPath()+"/.git --work-tree="+getGitPath()+" branch").get(0);
        }catch (Exception ex) {}
        return "*";
    }

    public String getGitPath() {
        return gitPath;
    }

    /**
     * @param gitPath the gitPath to set
     */
    public void setGitPath(String gitPath) {
        this.gitPath = gitPath;
    }
}
