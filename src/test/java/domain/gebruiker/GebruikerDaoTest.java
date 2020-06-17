//package domain.gebruiker;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.TypedQuery;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoJUnitRunner.class)
//class GebruikerDaoTest {
//
//    private Gebruiker gebruiker;
//
//    @Mock
//    private TypedQuery<Gebruiker> queryGebruikerMock;
//
//    @Mock
//    private EntityManager emMock;
//
//    @Mock
//    private EntityTransaction entityTransactionMock;
//
//    @InjectMocks
//    private GebruikerDao gebruikerDao;
//
//    private List<Gebruiker> gebruikers = new ArrayList<>();
//
//    @BeforeAll
//    void setup(){
//        gebruiker = Gebruiker.builder()
//                .naam("test artikel")
//                .emailadres("test@mail.com")
//                .build();
//    }
//
//    @Test
//    public void verifyFindByName() {
//        // given
//
//        // when
//        when(emMock.createQuery(anyString(), eq(Gebruiker.class))).thenReturn(queryGebruikerMock);
//        gebruikerDao.select("test@mail.com");
//
//        // then
//        verify(emMock).createQuery(anyString(), eq(Gebruiker.class));
//    }
//}
