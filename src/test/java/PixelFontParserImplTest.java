import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

//
// Don't edit this file
//
@RunWith(Parameterized.class)
public class PixelFontParserImplTest {

    private PixelFontParser pixelFontParser;

    private Integer[][] input;

    private Integer expectedOutput;

    private boolean isNumber;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return List.of(new Object[][]{
                {
                        new Integer[][]{
                                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                                {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}
                        },
                        98765,
                        true
                },
                {
                        new Integer[][]{
                                {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                                {1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1},
                                {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}
                        },
                        43210,
                        true
                },
                {
                        new Integer[][]{
                                {1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                        },
                        3068,
                        true
                },
                {
                        new Integer[][]{
                                {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
                                {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                                {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                                {1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                        },
                        2745,
                        true
                },
                {
                        new Integer[][]{
                                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                                {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                                {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                        },
                        9174,
                        true
                },
                {
                        new Integer[][]{
                                {1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                        },
                        5696,
                        true
                },
                {
                        new Integer[][]{
                                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                        },
                        null,
                        false
                }
        });
    }

    public PixelFontParserImplTest(Integer[][] input, Integer expectedOutput, boolean isNumber) {
        pixelFontParser =  new PixelFontParserImpl();
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.isNumber = isNumber;
    }

    @Test
    public void test() {
        if (isNumber) {
            var actualOutput = pixelFontParser.parseNumber(input);
            Assert.assertEquals(expectedOutput, actualOutput);
        } else {
            try {
                pixelFontParser.parseNumber(input);
            } catch (NumberFormatException e) {
                return;
            }
            Assert.fail("An exception was expected");
        }
    }

}
