package ro.cti.ssa.aossi.springercrawler.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author adrian.zamfirescu
 * @since 10/19/13
 */

public class ParserUtils {

    public static String getUrlSource(String url) throws IOException {

        URL uniformeResourceLocator = new URL(url);
        URLConnection urlConnection = uniformeResourceLocator.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line=in.readLine())!= null)
            stringBuilder.append(line);
        in.close();

        return stringBuilder.toString();
    }

    public static String removeComments(String text, String prefix, String suffix){

        StringBuilder cleanTextBuilder = new StringBuilder();

        boolean checkCommentSection = false;

        final String COMMENT_START = "<!--";
        final String COMMENT_END = "-->";

        int START_LENGTH = COMMENT_START.length() + prefix.length();
        int END_LENGTH = COMMENT_END.length() + suffix.length();
        int commentSectionEndIndex = -1;

        for (int index=0; index<text.length(); index++){

            if (index+START_LENGTH<text.length() && text.substring(index,index+START_LENGTH).equals(COMMENT_START+prefix))
                checkCommentSection = true;

            if (index+END_LENGTH<text.length() && text.substring(index,index+END_LENGTH).equals(suffix+COMMENT_END)){
                checkCommentSection = false;
                commentSectionEndIndex = 0;
            }

            if (!checkCommentSection){
                if (commentSectionEndIndex>=0){
                    commentSectionEndIndex++;
                    if (commentSectionEndIndex==END_LENGTH)
                        commentSectionEndIndex=-1;
                }
                else
                    cleanTextBuilder.append(text.charAt(index));
            }

        }

        return cleanTextBuilder.toString();

    }

}
