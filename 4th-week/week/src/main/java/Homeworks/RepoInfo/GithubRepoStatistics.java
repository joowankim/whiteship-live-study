package Homeworks.RepoInfo;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class GithubRepoStatistics {
    private GitHub github;
    private GHRepository githubRepo;

    public GithubRepoStatistics(String token, String repo) {
        GitHubBuilder builder = new GitHubBuilder();
        try {
            this.github = builder.withOAuthToken(token).build();
            this.githubRepo = this.github.getRepository(repo);         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<GHIssue> getAllIssues() {
        try {
            return this.githubRepo.getIssues(GHIssueState.ALL);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<GHIssueComment> getIssueComments(GHIssue issue) {
        try {
            return issue.getComments();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private GHUser getCommentAuthor(GHIssueComment comment) {
        try {
            return comment.getUser();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, Double> getParticipationData(List<GHIssue> issues) {
        Map<String, Set<Integer>> participationIssues = new HashMap<>();
        Map<String, Double> data = new HashMap<>();
        Double ISSUE_COUNT = (double) issues.size();

        for (GHIssue issue: issues) {
            for (GHIssueComment comment: getIssueComments(issue)) {
                String login = getCommentAuthor(comment).getLogin();
                Integer issueNumber = issue.getNumber();
                if (participationIssues.containsKey(login)) {
                    participationIssues.get(login).add(issueNumber);
                } else {
                    participationIssues.put(login, new HashSet<Integer>(Arrays.asList(issueNumber)));
                }
            }
        }
        
        for (String author: participationIssues.keySet()) {
            data.put(author, (double) (participationIssues.get(author).size() / ISSUE_COUNT));
        }
        return data;
    } 

    public void show() {
        List<GHIssue> issues = getAllIssues();
        Map<String, Double> data = getParticipationData(issues);
        System.out.println("참여자\t\t참여율");
        for (String author: data.keySet()) {
            System.out.println(author + "\t\t" + String.format("%.2f", data.get(author)));
        }
    }
}
