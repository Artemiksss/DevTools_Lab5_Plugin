

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class New_pr extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        String selectedText = editor.getSelectionModel().getSelectedText();

        if (selectedText != null) {
            String Highlighted = "";
            try {
                Highlighted = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String url = String.format("https://yandex.ru/search/?text=%s&search_source=dzen_desktop_safe&lr=2", Highlighted);
            BrowserUtil.browse(url);
        } else {
            Messages.showMessageDialog("You have not highlighted the text.", "Search Action", Messages.getInformationIcon());
        }
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}