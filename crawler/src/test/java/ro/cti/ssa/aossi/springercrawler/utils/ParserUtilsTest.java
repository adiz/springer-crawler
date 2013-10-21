package ro.cti.ssa.aossi.springercrawler.utils;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * @author adrian.zamfirescu
 * @since 10/19/13
 */
public class ParserUtilsTest {

    private static final String COMMENTS_START = "[if";
    private static final String COMMENTS_END = "[endif]";

    @Test
    public void should_replace_correct_alphanumeric_regex(){

        // when
        String text = "Inlocuieste <!--[if ce e aici cu[endif]--> cu nimic";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("Inlocuieste  cu nimic");

    }

    @Test
    public void should_replace_correct_metacharacter_regex_1(){

        // when
        String text = "<!DOCTYPE html>\n" +
                "<!--[if lt IE 7]> <html lang=\"en\" class=\"no-js ie6 lt-ie9 lt-ie8\"> <![endif]-->\n" +
                "<!--[if IE 7]>    <html lang=\"en\" class=\"no-js ie7 lt-ie9 lt-ie8\"> <![endif]-->\n" +
                "<!--[if IE 8]>    <html lang=\"en\" class=\"no-js ie8 lt-ie9\"> <![endif]-->\n" +
                "<!--[if IE 9]>    <html lang=\"en\" class=\"no-js ie9\"> <![endif]-->\n" +
                "<!--[if gt IE 9]><!--> <html lang=\"en\" class=\"no-js\"> <!--<![endif]-->\n" +
                "<head>";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("<!DOCTYPE html>\n\n\n\n\n\n<head>");

    }

    @Test
    public void should_replace_correct_metacharacter_regex_2(){

        // when
        String text = "<link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon-32x32.png\"/>\n" +
                "  <!--[if IE]>\n" +
                "    <link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon.ico\"/>\n" +
                "  <![endif]-->\n" +
                "  <meta name=\"msapplication-TileColor\" content=\"#FFFFFF\"/>";

        // then
        String replacedText = ParserUtils.removeComments(text, COMMENTS_START, COMMENTS_END);

        // assert
        Assertions.assertThat(replacedText).isEqualTo("<link rel=\"shortcut icon\" href=\"/static/0.6867/sites/link/images/favicon-32x32.png\"/>\n  \n  <meta name=\"msapplication-TileColor\" content=\"#FFFFFF\"/>");

    }

}
