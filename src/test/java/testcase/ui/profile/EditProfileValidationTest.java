package testcase.ui.profile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfileModal;
import pages.ProfilePage;
@SuppressWarnings("unused")
public class EditProfileValidationTest extends ProfileTestBase {
    // UI group: TC_29 -> TC_60
    @Test(description = "Edit profile modal should open with core controls", enabled = false)
    public void verifyEditProfileModalDisplaysCoreControls() {
        ProfilePage profilePage = openProfilePage();
        profilePage.openEditProfileModal();
        EditProfileModal editProfileModal = profilePage.getEditProfileModal();
        editProfileModal.waitForModal();
        Assert.assertTrue(editProfileModal.isModalDisplayed(), "TODO: confirm modal title locator");
        Assert.assertTrue(editProfileModal.isFieldsDisplayed(), "TODO: confirm modal field locators");
        Assert.assertTrue(editProfileModal.isSubmitButtonDisplayed(), "TODO: confirm submit button locator");
        Assert.assertTrue(editProfileModal.isCloseButtonDisplayed(), "TODO: confirm close button locator");
    }
    @Test(description = "Edit profile validation skeleton for empty fullname", enabled = false)
    public void verifyEditProfileValidationSkeleton() {
        ProfilePage profilePage = openProfilePage();
        profilePage.openEditProfileModal();
        EditProfileModal editProfileModal = profilePage.getEditProfileModal();
        editProfileModal.fillFullName("");
        // TODO: replace with real error locator/message assertion.
        Assert.assertTrue(true, "TODO: assert validation message after locator confirmation");
    }
}
