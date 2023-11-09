package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.dto.ScrapedWebInfoDTO;
import com.sv.webscrapper.domain.dto.ScrappedLinkDto;
import com.sv.webscrapper.service.WebScrapperService;
import lombok.extern.slf4j.Slf4j;
import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlAnchor;
import org.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class WebScrapperInterfaceImpl implements WebScrapperService {

    @Override
    public ScrapedWebInfoDTO scrape(String url) {
        final WebClient webClient = getWebClient();
        try {
            HtmlPage page = webClient.getPage(url);
            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            List<HtmlAnchor> anchors = page.getAnchors();
            List<ScrappedLinkDto> scrappedLinkDtos = anchors.stream().filter(a -> a.getHrefAttribute().contains("http")).
                    map(a -> ScrappedLinkDto.builder()
                            .name((null == a.getFirstChild() || "".equals(a.getFirstChild().asNormalizedText())) ? "No info" : a.getFirstChild().asNormalizedText())
                            .url(a.getHrefAttribute())
                            .build()).toList();

            return ScrapedWebInfoDTO.builder()
                    .webPageName(page.getTitleText())
                    .scrappedLinkDtos(scrappedLinkDtos)
                    .build();

        } catch (IOException e) {
            log.error("An error occurred: " + e);
            return ScrapedWebInfoDTO.builder().build();
        } finally {
            webClient.close();
        }
    }

    private static WebClient getWebClient() {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        return webClient;
    }
}
