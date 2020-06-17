package domain.artikel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtikelServiceTest {

    private ArtikelService target;

    @BeforeEach
    void setup() {
        target = new ArtikelService();
    }

    @Test
    void stringToSoortIsNietHoofdlettergevoelig() {
        // given

        // when
        Soort testCase1 = target.stringToSoort("onbekend");
        Soort testCase2 = target.stringToSoort("Onbekend");
        Soort testCase3 = target.stringToSoort("oNbeKeNd");
        Soort testCase4 = target.stringToSoort("ONBEKEND");

        // then
        assertEquals(Soort.ONBEKEND, testCase1);
        assertEquals(Soort.ONBEKEND, testCase2);
        assertEquals(Soort.ONBEKEND, testCase3);
        assertEquals(Soort.ONBEKEND, testCase4);
    }

    @Test
    void stringToSoortverwijderdSpaties() {
        // given

        // when
        Soort testCase1 = target.stringToSoort(" onbekend");
        Soort testCase2 = target.stringToSoort("o n b e k e n d");
        Soort testCase3 = target.stringToSoort("onbekend ");
        Soort testCase4 = target.stringToSoort("onbekend         ");

        // then
        assertEquals(Soort.ONBEKEND, testCase1);
        assertEquals(Soort.ONBEKEND, testCase2);
        assertEquals(Soort.ONBEKEND, testCase3);
        assertEquals(Soort.ONBEKEND, testCase4);
    }

    @Test
    void stringToSoortGeeftCorrecteSoortTerug() {
        // given

        // when
        Soort testCase1 = target.stringToSoort("onbekend");
        Soort testCase2 = target.stringToSoort("product");
        Soort testCase3 = target.stringToSoort("dienst");
        Soort testCase4 = target.stringToSoort("artikel");

        // then
        assertEquals(Soort.ONBEKEND, testCase1);
        assertEquals(Soort.PRODUCT, testCase2);
        assertEquals(Soort.DIENST, testCase3);
        assertEquals(Soort.ONBEKEND, testCase4);
    }
}
