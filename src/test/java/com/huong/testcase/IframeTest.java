package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.pages.IframePage;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    IframePage iframePage;

    @Test
    public void closeIframe() throws InterruptedException {
        iframePage = new IframePage();
        iframePage.handleIframe();
    }
}
