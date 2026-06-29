package testcase.ui.blog;


import base.BaseTest;
import constants.TimeOutConstant;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlogPage;


import java.util.List;


public class BlogTest extends BaseTest {
    private BlogPage blogPage;


    @BeforeMethod
    public void setUp() {
        maximizeWindow();


        // Hàm openUrl mới có try-catch chống sập toàn suite
        openUrl("/blog");


        blogPage = new BlogPage(getDriver());


        // Điểm mấu chốt: Explicit wait bên trong hàm này sẽ đảm bảo
        // giao diện hiện ra là test luôn, chấp nhận trang web vẫn đang loading ngầm.
        blogPage.waitForBlogPageLoaded();
    }


    // =========================================================================
    // NHÓM KIỂM TRA BÀI VIẾT (MAIN CARDS)
    // =========================================================================


    @Test(priority = 1, description = "Xác minh hiển thị tiêu đề chính của trang Blog")
    public void TC_01_verifyBlogHeaderDisplayed() {
        String header = blogPage.getBlogHeaderText();
        System.out.println("[TC_01] Blog header: " + header);
        Assert.assertFalse(header.isEmpty(), "Tiêu đề trang Blog bị rỗng");
    }


    @Test(priority = 2, description = "Xác minh tiêu đề của bài viết đầu tiên hiển thị")
    public void TC_02_verifyFirstBlogTitleDisplayed() {
        String title = blogPage.getBlogTitleOfCard(1);
        System.out.println("[TC_02] Tiêu đề bài 1: " + title);
        Assert.assertFalse(title.isEmpty(), "Tiêu đề bài 1 bị rỗng");
    }


    @Test(priority = 3, description = "Xác minh tất cả các bài viết đều có tiêu đề hợp lệ")
    public void TC_03_verifyAllBlogTitlesDisplayed() {
        List<WebElement> titles = blogPage.getAllBlogTitles();
        System.out.println("[TC_03] Tổng số bài: " + titles.size());
        Assert.assertTrue(titles.size() > 0, "Không có bài nào hiển thị");


        for (int i = 0; i < titles.size(); i++) {
            String text = titles.get(i).getText();
            System.out.println("  Bài " + (i + 1) + ": " + text);
            Assert.assertFalse(text.isEmpty(), "Tiêu đề bài " + (i + 1) + " bị rỗng");
        }
    }


    @Test(priority = 4, description = "Xác minh hình ảnh bài viết đầu tiên hiển thị và có thuộc tính src")
    public void TC_04_verifyFirstBlogImageDisplayed() {
        String src = blogPage.getBlogImageSrc(1);
        System.out.println("[TC_04] Ảnh bài 1 src: " + src);
        Assert.assertTrue(blogPage.isBlogImageDisplayed(1), "Ảnh bài 1 không hiển thị");
        Assert.assertNotNull(src, "src ảnh bài 1 bị null");
        Assert.assertFalse(src.isEmpty(), "src ảnh bài 1 bị rỗng");
    }


    @Test(priority = 5, description = "Xác minh tất cả hình ảnh bài viết đều có src hợp lệ")
    public void TC_05_verifyAllBlogImagesDisplayed() {
        List<WebElement> images = blogPage.getAllBlogImages();
        System.out.println("[TC_05] Tổng số ảnh: " + images.size());
        Assert.assertTrue(images.size() > 0, "Không có ảnh nào");


        for (int i = 0; i < images.size(); i++) {
            String src = images.get(i).getAttribute("src");
            System.out.println("  Ảnh " + (i + 1) + ": " + src);
            Assert.assertNotNull(src, "Ảnh " + (i + 1) + " không có thuộc tính src (null)");
            Assert.assertFalse(src.isEmpty(), "Ảnh " + (i + 1) + " có src bị rỗng");
        }
    }


    @Test(priority = 6, description = "Xác minh tên tác giả của bài viết đầu tiên hiển thị")
    public void TC_06_verifyFirstAuthorDisplayed() {
        String author = blogPage.getAuthorOfCard(1);
        System.out.println("[TC_06] Tác giả bài 1: " + author);
        Assert.assertFalse(author.isEmpty(), "Tên tác giả bài 1 bị rỗng");
    }


    @Test(priority = 7, description = "Xác minh tất cả bài viết đều hiển thị tên tác giả")
    public void TC_07_verifyAllAuthorsDisplayed() {
        List<WebElement> authors = blogPage.getAllAuthors();
        System.out.println("[TC_07] Tổng tác giả: " + authors.size());
        Assert.assertTrue(authors.size() > 0, "Không có tác giả nào");


        for (int i = 0; i < authors.size(); i++) {
            String name = authors.get(i).getText();
            System.out.println("  Bài " + (i + 1) + " — Tác giả: " + name);
            Assert.assertFalse(name.isEmpty(), "Tác giả bài " + (i + 1) + " bị rỗng");
        }
    }


    @Test(priority = 8, description = "Xác minh các chỉ số tương tác (Like, Comment, View) của bài 1 là chữ số")
    public void TC_08_verifyStatsOfCard1() {
        String like = blogPage.getLikeOfCard(1);
        String comment = blogPage.getCommentOfCard(1);
        String view = blogPage.getViewOfCard(1);
        System.out.println("[TC_08] Bài 1 — Like: " + like + " | Comment: " + comment + " | View: " + view);


        Assert.assertTrue(like.matches("\\d+"), "Like không phải số — actual: " + like);
        Assert.assertTrue(comment.matches("\\d+"), "Comment không phải số — actual: " + comment);
        Assert.assertTrue(view.matches("\\d+"), "View không phải số — actual: " + view);
    }


    @Test(priority = 9, description = "Xác minh các chỉ số tương tác của tất cả bài viết đều là chữ số")
    public void TC_09_verifyAllStatsDisplayed() {
        List<WebElement> titles = blogPage.getAllBlogTitles();
        for (int i = 1; i <= titles.size(); i++) {
            String like = blogPage.getLikeOfCard(i);
            String comment = blogPage.getCommentOfCard(i);
            String view = blogPage.getViewOfCard(i);
            System.out.println("[TC_09] Bài " + i + " — Like: " + like + " | Comment: " + comment + " | View: " + view);


            Assert.assertTrue(like.matches("\\d+"), "Bài " + i + ": Like không phải số");
            Assert.assertTrue(comment.matches("\\d+"), "Bài " + i + ": Comment không phải số");
            Assert.assertTrue(view.matches("\\d+"), "Bài " + i + ": View không phải số");
        }
    }


    @Test(priority = 10, description = "Xác minh phần mô tả ngắn của bài viết 1 hiển thị")
    public void TC_10_verifyFirstDescriptionDisplayed() {
        String desc = blogPage.getDescriptionOfCard(1);
        System.out.println("[TC_10] Mô tả bài 1: " + desc);
        Assert.assertFalse(desc.isEmpty(), "Mô tả bài 1 bị rỗng");
    }


    @Test(priority = 11, description = "Xác minh phần mô tả ngắn của tất cả các bài viết hiển thị")
    public void TC_11_verifyAllDescriptionsDisplayed() {
        List<WebElement> descs = blogPage.getAllDescriptions();
        System.out.println("[TC_11] Tổng mô tả: " + descs.size());
        Assert.assertTrue(descs.size() > 0, "Không có mô tả nào");


        for (int i = 0; i < descs.size(); i++) {
            String text = descs.get(i).getText();
            System.out.println("  Bài " + (i + 1) + ": " + text);
            Assert.assertFalse(text.isEmpty(), "Mô tả bài " + (i + 1) + " bị rỗng");
        }
    }


    // =========================================================================
    // NHÓM KIỂM TRA SIDEBAR (CHỦ ĐỀ ĐỀ XUẤT & BÀI VIẾT GỢI Ý)
    // =========================================================================


    @Test(priority = 12, description = "Xác minh hiển thị tiêu đề nhóm Chủ đề đề xuất")
    public void TC_12_verifySuggestedTopicsTitleDisplayed() {
        String title = blogPage.getSuggestedTopicsTitleText();
        System.out.println("[TC_12] Tiêu đề chủ đề: " + title);
        Assert.assertFalse(title.isEmpty(), "Tiêu đề chủ đề bị rỗng");
    }


    @Test(priority = 13, description = "Xác minh hiển thị đủ số lượng 7 chủ đề ở sidebar")
    public void TC_13_verifyAllTopicLinksDisplayed() {
        List<WebElement> topics = blogPage.getAllTopicLinks();
        System.out.println("[TC_13] Tổng topic: " + topics.size());
        for (int i = 0; i < topics.size(); i++) {
            System.out.println("  Topic " + (i + 1) + ": " + topics.get(i).getText());
        }
        Assert.assertEquals(topics.size(), 7, "Số lượng topic không đúng — expected 7, actual: " + topics.size());
    }


    @Test(priority = 14, description = "Xác minh hiển thị tiêu đề nhóm Bài viết đề xuất")
    public void TC_14_verifySuggestedPostsTitleDisplayed() {
        String title = blogPage.getSuggestedPostsTitleText();
        System.out.println("[TC_14] Tiêu đề suggested posts: " + title);
        Assert.assertFalse(title.isEmpty(), "Tiêu đề bài đăng đề xuất bị rỗng");
    }


    @Test(priority = 15, description = "Xác minh thông tin (Tiêu đề, Mô tả, Tác giả) bài viết đề xuất đầu tiên")
    public void TC_15_verifySuggestedPost1Displayed() {
        String title = blogPage.getSuggestedTitleOfPost(1);
        String desc = blogPage.getSuggestedDescOfPost(1);
        String author = blogPage.getSuggestedAuthorOfPost(1);
        System.out.println("[TC_15] Suggested post 1 — Tiêu đề: " + title + " | Tác giả: " + author);


        Assert.assertFalse(title.isEmpty(), "Tiêu đề suggested post 1 bị rỗng");
        Assert.assertFalse(desc.isEmpty(), "Mô tả suggested post 1 bị rỗng");
        Assert.assertFalse(author.isEmpty(), "Tác giả suggested post 1 bị rỗng");
    }


    @Test(priority = 16, description = "Xác minh thông tin tất cả bài viết đề xuất đầy đủ")
    public void TC_16_verifyAllSuggestedPostsDisplayed() {
        List<WebElement> titles = blogPage.getAllSuggestedTitles();
        System.out.println("[TC_16] Tổng suggested posts: " + titles.size());
        Assert.assertTrue(titles.size() > 0, "Không có suggested post nào");


        for (int i = 1; i <= titles.size(); i++) {
            String title = blogPage.getSuggestedTitleOfPost(i);
            String desc = blogPage.getSuggestedDescOfPost(i);
            String author = blogPage.getSuggestedAuthorOfPost(i);
            System.out.println("  Post " + i + ": " + title + " | " + author);


            Assert.assertFalse(title.isEmpty(), "Suggested post " + i + ": tiêu đề rỗng");
            Assert.assertFalse(desc.isEmpty(), "Suggested post " + i + ": mô tả rỗng");
            Assert.assertFalse(author.isEmpty(), "Suggested post " + i + ": tác giả rỗng");
        }
    }


    // =========================================================================
    // NHÓM ĐIỀU HƯỚNG & HÀNH VI (NAVIGATION & ACTIONS)
    // =========================================================================


    @Test(priority = 17, description = "Xác minh chuyển trang thành công khi nhấn 'Xem thêm' ở Bài viết 1")
    public void TC_17_verifyClickViewMoreCard1() {
        String beforeUrl = blogPage.getCurrentUrl();
        blogPage.clickViewMoreOfCard(1);
        blogPage.waitForUrlChange(beforeUrl, TimeOutConstant.TIME_OUT_LONG);


        String afterUrl = blogPage.getCurrentUrl();
        System.out.println("[TC_17] URL sau click Xem thêm card 1: " + afterUrl);
        Assert.assertNotEquals(afterUrl, beforeUrl, "URL không thay đổi sau click Xem thêm card 1");
    }


    @Test(priority = 18, description = "Xác minh chuyển trang thành công khi nhấn 'Xem thêm' ở Bài viết 2")
    public void TC_18_verifyClickViewMoreCard2() {
        String beforeUrl = blogPage.getCurrentUrl();
        blogPage.clickViewMoreOfCard(2);
        blogPage.waitForUrlChange(beforeUrl, TimeOutConstant.TIME_OUT_LONG);


        String afterUrl = blogPage.getCurrentUrl();
        System.out.println("[TC_18] URL sau click Xem thêm card 2: " + afterUrl);
        Assert.assertNotEquals(afterUrl, beforeUrl, "URL không thay đổi sau click Xem thêm card 2");
    }


    @Test(priority = 19, description = "Xác minh chuyển đổi URL thành công khi click Topic Front-end")
    public void TC_19_verifyClickTopicFrontend() {
        String name = "Front-end / Mobile apps";
        String beforeUrl = blogPage.getCurrentUrl();
        String href = blogPage.getTopicHrefByName(name);
        System.out.println("[TC_19] Href Front-end: " + href);
        Assert.assertFalse(href == null || href.isEmpty(), "Href topic Front-end bị rỗng");


        blogPage.clickTopicByNameAndWait(name);
        System.out.println("[TC_19] URL sau click: " + blogPage.getCurrentUrl());
        Assert.assertNotEquals(blogPage.getCurrentUrl(), beforeUrl, "Vẫn ở trang Blog sau click Front-end");
    }


    @Test(priority = 20, description = "Xác minh chuyển đổi URL thành công khi click Topic UI/UX")
    public void TC_20_verifyClickTopicUIUX() {
        String name = "UI / UX / Design";
        String beforeUrl = blogPage.getCurrentUrl();
        blogPage.clickTopicByNameAndWait(name);
        System.out.println("[TC_20] URL sau click UI/UX: " + blogPage.getCurrentUrl());
        Assert.assertNotEquals(blogPage.getCurrentUrl(), beforeUrl, "Vẫn ở trang Blog sau click UI/UX");
    }


    @Test(priority = 21, description = "Xác minh chuyển đổi URL thành công khi click Topic BACK-END")
    public void TC_21_verifyClickTopicBackend() {
        String name = "BACK-END";
        String beforeUrl = blogPage.getCurrentUrl();
        blogPage.clickTopicByNameAndWait(name);
        System.out.println("[TC_21] URL sau click BACK-END: " + blogPage.getCurrentUrl());
        Assert.assertNotEquals(blogPage.getCurrentUrl(), beforeUrl, "Vẫn ở trang Blog sau click BACK-END");
    }


    @Test(priority = 22, description = "Xác minh tất cả liên kết các topic (href) tại sidebar đều hợp lệ")
    public void TC_22_verifyAllTopicHrefsValid() {
        List<WebElement> topics = blogPage.getAllTopicLinks();
        System.out.println("[TC_22] Kiểm tra href " + topics.size() + " topic");


        for (int i = 0; i < topics.size(); i++) {
            String topicName = topics.get(i).getText();
            String href = topics.get(i).getAttribute("href");
            System.out.println("  Topic " + (i + 1) + ": " + topicName + " → " + href);
            Assert.assertNotNull(href, "Topic '" + topicName + "' bị null thuộc tính href");
            Assert.assertFalse(href.isEmpty(), "Topic '" + topicName + "' bị rỗng href");
        }
    }


    @Test(priority = 23, description = "Xác minh chức năng nút Tải thêm bài viết hoạt động chính xác (tăng số lượng card)")
    public void TC_23_verifyClickLoadMoreButton() {
        int countBefore = blogPage.getAllBlogTitles().size();
        System.out.println("[TC_23] Số bài trước khi click: " + countBefore);


        blogPage.clickLoadMoreAndWaitForMoreCards();


        int countAfter = blogPage.getAllBlogTitles().size();
        System.out.println("[TC_23] Số bài sau khi click: " + countAfter);
        Assert.assertTrue(countAfter > countBefore, "Số bài không tăng — before: " + countBefore + ", after: " + countAfter);
    }
}

