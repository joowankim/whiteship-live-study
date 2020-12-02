package Homeworks;

import Homeworks.RepoInfo.GithubRepoStatistics;

public class App {
    public static void main(String[] args) {
        final String OAuthToken = "";
        String repo = "whiteship/live-study";

        GithubRepoStatistics statistics = new GithubRepoStatistics(OAuthToken, repo);
        statistics.show();
    }
}