package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlAnchor;
import org.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
@Slf4j
public class WebScrapperInterfaceImpl implements WebScrapperService {

    @Override
    public void scrape(String url) {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        try {
            HtmlPage page = webClient.getPage(url);
            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            List<HtmlAnchor> anchors = page.getAnchors();
            anchors.stream().filter(a -> a.getHrefAttribute().contains("http")).forEach(a -> log.info(a.getHrefAttribute()));
            anchors.stream().filter(a -> a.getHrefAttribute().contains("http")).forEach(a -> {
                if ("".equals(a.getFirstChild().asNormalizedText())) log.info("No name info");
                else log.info(a.getFirstChild().asNormalizedText());
            });
            log.info(page.getTitleText());
        } catch (IOException e) {
            log.error("An error occurred: " + e);
        } finally {
            webClient.close();
        }

    }
}
