package io.catalyte.training.components;

import io.catalyte.training.domains.customers.Customer;
import io.catalyte.training.domains.products.Product;
import io.catalyte.training.repositories.CustomerRepository;
import io.catalyte.training.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadProducts();
        loadCustomers();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    private void loadProducts() {
        productRepository.save(new Product(parseDate("2019-06-03"), 80, "kids", "basketball", "pants", false, 37.52, "pants grey", "kids basketball pants in grey", 78, 1));
        productRepository.save(new Product(parseDate("2019-02-06"), 52, "mens", "basketball", "pants", false, 23.77, "pants black", "mens basketball pants in black", 89, 2));
        productRepository.save(new Product(parseDate("2019-05-14"), 35, "womens", "basketball", "pants", false, 16.37, "pants black", "womens basketball pants in black", 1, 3));
        productRepository.save(new Product(parseDate("2019-08-04"), 91, "kids", "running", "pants", false, 40.36, "pants pink", "kids running pants in pink", 65, 4));
        productRepository.save(new Product(parseDate("2019-05-25"), 25, "mens", "running", "pants", false, 9.34, "pants grey", "mens running pants in grey", 44, 5));
        productRepository.save(new Product(parseDate("2019-07-08"), 42, "womens", "running", "pants", false, 48.64, "pants blue", "womens running pants in blue", 20, 6));
        productRepository.save(new Product(parseDate("2019-06-16"), 84, "kids", "soccer", "pants", false, 24.89, "pants grey", "kids soccer pants in grey", 53, 7));
        productRepository.save(new Product(parseDate("2019-07-24"), 21, "mens", "soccer", "pants", false, 49.52, "pants black", "mens soccer pants in black", 84, 8));
        productRepository.save(new Product(parseDate("2019-03-09"), 42, "womens", "soccer", "pants", false, 52.82, "pants black", "womens soccer pants in black", 66, 9));
        productRepository.save(new Product(parseDate("2019-06-07"), 42, "kids", "golf", "pants", false, 104.11, "pants pink", "kids golf pants in pink", 75, 10));
        productRepository.save(new Product(parseDate("2019-05-25"), 86, "mens", "golf", "pants", false, 39.95, "pants grey", "mens golf pants in grey", 68, 11));
        productRepository.save(new Product(parseDate("2019-10-01"), 98, "womens", "golf", "pants", false, 27.15, "pants blue", "womens golf pants in blue", 61, 12));
        productRepository.save(new Product(parseDate("2019-08-21"), 37, "kids", "basketball", "shoes", false, 60.53, "shoes grey", "kids basketball shoes in grey", 31, 13));
        productRepository.save(new Product(parseDate("2019-09-29"), 23, "mens", "basketball", "shoes", false, 35.64, "shoes black", "mens basketball shoes in black", 86, 14));
        productRepository.save(new Product(parseDate("2019-07-09"), 24, "womens", "basketball", "shoes", false, 73.88, "shoes black", "womens basketball shoes in black", 19, 15));
        productRepository.save(new Product(parseDate("2019-06-07"), 42, "kids", "running", "shoes", false, 43.71, "shoes purple", "kids running shoes in purple", 26, 16));
        productRepository.save(new Product(parseDate("2019-06-06"), 16, "mens", "running", "shoes", false, 91.00, "shoes black", "mens running shoes in black", 71, 17));
        productRepository.save(new Product(parseDate("2019-04-14"), 28, "womens", "running", "shoes", false, 71.14, "shoes black", "womens running shoes in black", 70, 18));
        productRepository.save(new Product(parseDate("2019-05-08"), 90, "kids", "soccer", "shoes", false, 12.71, "shoes grey", "kids soccer shoes in grey", 26, 19));
        productRepository.save(new Product(parseDate("2019-08-30"), 11, "mens", "soccer", "shoes", false, 100.13, "shoes black", "mens soccer shoes in black", 31, 20));
        productRepository.save(new Product(parseDate("2019-04-21"), 49, "womens", "soccer", "shoes", false, 10.59, "shoes black", "womens soccer shoes in black", 64, 21));
        productRepository.save(new Product(parseDate("2019-05-29"), 11, "kids", "golf", "shoes", false, 16.44, "shoes purple", "kids golf shoes in purple", 36, 22));
        productRepository.save(new Product(parseDate("2019-01-09"), 14, "mens", "golf", "shoes", false, 69.7, "shoes black", "mens golf shoes in black", 54, 23));
        productRepository.save(new Product(parseDate("2019-03-28"), 84, "womens", "golf", "shoes", false, 97.63, "shoes black", "womens golf shoes in black", 50, 24));
        productRepository.save(new Product(parseDate("2019-03-18"), 64, "kids", "basketball", "shorts", false, 9.93, "shorts black", "kids basketball shorts in black", 57, 25));
        productRepository.save(new Product(parseDate("2019-04-03"), 15, "mens", "basketball", "shorts", false, 61.38, "shorts blue", "mens basketball shorts in blue", 37, 26));
        productRepository.save(new Product(parseDate("2019-05-20"), 84, "womens", "basketball", "shorts", false, 40.44, "shorts black", "womens basketball shorts in black", 16, 27));
        productRepository.save(new Product(parseDate("2019-07-05"), 88, "kids", "running", "shorts", false, 56.95, "shorts grey", "kids running shorts in grey", 52, 28));
        productRepository.save(new Product(parseDate("2019-07-17"), 57, "mens", "running", "shorts", false, 45.54, "shorts blue", "mens running shorts in blue", 21, 29));
        productRepository.save(new Product(parseDate("2019-05-10"), 19, "womens", "running", "shorts", false, 78.13, "shorts black", "womens running shorts in black", 28, 30));
        productRepository.save(new Product(parseDate("2019-07-24"), 6, "kids", "soccer", "shorts", false, 81.95, "shorts black", "kids soccer shorts in black", 45, 31));
        productRepository.save(new Product(parseDate("2019-09-10"), 35, "mens", "soccer", "shorts", false, 42.59, "shorts blue", "mens soccer shorts in blue", 98, 32));
        productRepository.save(new Product(parseDate("2019-05-03"), 67, "womens", "soccer", "shorts", false, 38.3, "shorts black", "womens soccer shorts in black", 88, 33));
        productRepository.save(new Product(parseDate("2019-08-16"), 25, "kids", "golf", "shorts", false, 35.11, "shorts grey", "kids golf shorts in grey", 66, 34));
        productRepository.save(new Product(parseDate("2019-04-12"), 58, "mens", "golf", "shorts", false, 95.36, "shorts blue", "mens golf shorts in blue", 68, 35));
        productRepository.save(new Product(parseDate("2019-07-28"), 15, "womens", "golf", "shorts", false, 39.38, "shorts black", "womens golf shorts in black", 14, 36));
        productRepository.save(new Product(parseDate("2019-08-19"), 13, "kids", "basketball", "pants", false, 50.47, "pants grey 70", "kids basketball pants in grey 79", 40, 1));
        productRepository.save(new Product(parseDate("2019-05-13"), 90, "mens", "basketball", "pants", false, 38.72, "pants black 53", "mens basketball pants in black 95", 20, 2));
        productRepository.save(new Product(parseDate("2019-04-22"), 63, "womens", "basketball", "pants", false, 64.83, "pants black 93", "womens basketball pants in black 21", 82, 3));
        productRepository.save(new Product(parseDate("2019-01-05"), 67, "kids", "running", "pants", false, 23.48, "pants pink 88", "kids running pants in pink 92", 43, 4));
        productRepository.save(new Product(parseDate("2019-02-01"), 14, "mens", "running", "pants", false, 69.94, "pants grey 10", "mens running pants in grey 23", 56, 5));
        productRepository.save(new Product(parseDate("2019-09-11"), 44, "womens", "running", "pants", false, 32.56, "pants blue 56", "womens running pants in blue 17", 58, 6));
        productRepository.save(new Product(parseDate("2019-09-14"), 34, "kids", "soccer", "pants", false, 105.91, "pants grey 80", "kids soccer pants in grey 11", 13, 7));
        productRepository.save(new Product(parseDate("2019-08-19"), 83, "mens", "soccer", "pants", false, 75.08, "pants black 39", "mens soccer pants in black 40", 19, 8));
        productRepository.save(new Product(parseDate("2019-09-22"), 14, "womens", "soccer", "pants", false, 70.67, "pants black 57", "womens soccer pants in black 52", 15, 9));
        productRepository.save(new Product(parseDate("2019-03-30"), 34, "kids", "golf", "pants", false, 19.35, "pants pink 73", "kids golf pants in pink 28", 26, 10));
        productRepository.save(new Product(parseDate("2019-03-08"), 56, "mens", "golf", "pants", false, 41.53, "pants grey 34", "mens golf pants in grey 96", 74, 11));
        productRepository.save(new Product(parseDate("2019-05-26"), 10, "womens", "golf", "pants", false, 51.05, "pants blue 16", "womens golf pants in blue 31", 57, 12));
        productRepository.save(new Product(parseDate("2019-03-14"), 12, "kids", "basketball", "shoes", false, 46.81, "shoes grey 56", "kids basketball shoes in grey 63", 70, 13));
        productRepository.save(new Product(parseDate("2019-02-05"), 43, "mens", "basketball", "shoes", false, 73.81, "shoes black 29", "mens basketball shoes in black 6", 92, 14));
        productRepository.save(new Product(parseDate("2019-01-31"), 35, "womens", "basketball", "shoes", false, 101.97, "shoes black 87", "womens basketball shoes in black 94", 90, 15));
        productRepository.save(new Product(parseDate("2019-02-11"), 18, "kids", "running", "shoes", false, 62.79, "shoes purple 85", "kids running shoes in purple 83", 29, 16));
        productRepository.save(new Product(parseDate("2019-07-08"), 100, "mens", "running", "shoes", false, 59.28, "shoes black 91", "mens running shoes in black 74", 62, 17));
        productRepository.save(new Product(parseDate("2019-06-09"), 44, "womens", "running", "shoes", false, 11.41, "shoes black 43", "womens running shoes in black 76", 55, 18));
        productRepository.save(new Product(parseDate("2019-03-23"), 92, "kids", "soccer", "shoes", false, 101.54, "shoes grey 35", "kids soccer shoes in grey 78", 54, 19));
        productRepository.save(new Product(parseDate("2019-03-02"), 78, "mens", "soccer", "shoes", false, 10.11, "shoes black 90", "mens soccer shoes in black 37", 64, 20));
        productRepository.save(new Product(parseDate("2019-08-19"), 69, "womens", "soccer", "shoes", false, 102.93, "shoes black 34", "womens soccer shoes in black 58", 9, 21));
        productRepository.save(new Product(parseDate("2019-08-06"), 54, "kids", "golf", "shoes", false, 45.03, "shoes purple 40", "kids golf shoes in purple 17", 60, 22));
        productRepository.save(new Product(parseDate("2019-01-01"), 16, "mens", "golf", "shoes", false, 77.52, "shoes black 93", "mens golf shoes in black 52", 84, 23));
        productRepository.save(new Product(parseDate("2019-05-26"), 39, "womens", "golf", "shoes", false, 56.42, "shoes black 58", "womens golf shoes in black 5", 9, 24));
        productRepository.save(new Product(parseDate("2019-04-11"), 22, "kids", "basketball", "shorts", false, 84.78, "shorts black 83", "kids basketball shorts in black 13", 60, 25));
        productRepository.save(new Product(parseDate("2019-03-21"), 88, "mens", "basketball", "shorts", false, 86.99, "shorts blue 60", "mens basketball shorts in blue 38", 40, 26));
        productRepository.save(new Product(parseDate("2019-09-18"), 36, "womens", "basketball", "shorts", false, 22.37, "shorts black 43", "womens basketball shorts in black 78", 80, 27));
        productRepository.save(new Product(parseDate("2019-01-04"), 74, "kids", "running", "shorts", false, 58.53, "shorts grey 2", "kids running shorts in grey 31", 20, 28));
        productRepository.save(new Product(parseDate("2019-06-01"), 14, "mens", "running", "shorts", false, 86.58, "shorts blue 73", "mens running shorts in blue 34", 52, 29));
        productRepository.save(new Product(parseDate("2019-05-21"), 74, "womens", "running", "shorts", false, 28.95, "shorts black 56", "womens running shorts in black 26", 60, 30));
        productRepository.save(new Product(parseDate("2019-04-06"), 34, "kids", "soccer", "shorts", false, 32.91, "shorts black 17", "kids soccer shorts in black 7", 68, 31));
        productRepository.save(new Product(parseDate("2019-08-13"), 55, "mens", "soccer", "shorts", false, 48.34, "shorts blue 13", "mens soccer shorts in blue 82", 14, 32));
        productRepository.save(new Product(parseDate("2019-05-27"), 99, "womens", "soccer", "shorts", false, 19.95, "shorts black 95", "womens soccer shorts in black 13", 30, 33));
        productRepository.save(new Product(parseDate("2019-01-01"), 13, "kids", "golf", "shorts", false, 89.62, "shorts grey 54", "kids golf shorts in grey 9", 71, 34));
        productRepository.save(new Product(parseDate("2019-03-26"), 88, "mens", "golf", "shorts", false, 46.85, "shorts blue 19", "mens golf shorts in blue 72", 87, 35));
        productRepository.save(new Product(parseDate("2019-08-28"), 81, "womens", "golf", "shorts", false, 27.32, "shorts black 45", "womens golf shorts in black 4", 48, 36));
    }

    private void loadCustomers() {
        customerRepository.save(new Customer("CUSTOMER", "Andre", "Wilkins", "test@email.com", "password", "(903) 283-8342", "1782 Luspub Mill", "Jophubro", "NV", "14634", "USA", "378912708940614", "05/24", "404"));
        customerRepository.save(new Customer("CUSTOMER", "Allen", "Griffin", "bume@huin.it", "password", "(309) 566-2804", "841 Dutu Boulevard", "Evilofcaf", "ME", "71600", "USA", "343309350665775", "10/21", "430"));
        customerRepository.save(new Customer("CUSTOMER", "Leonard", "Sparks", "keguw@foakfa.ar", "password", "(288) 827-0472", "744 Uwzi Center", "Zismuja", "NM", "92987", "USA", "371205293567471", "07/21", "706"));
        customerRepository.save(new Customer("CUSTOMER", "Etta", "Williamson", "ettaw@puv.be", "password", "(285) 525-1197", "227 Efuv Avenue", "Nijazu", "MD", "08044", "USA", "345090429067106", "10/22", "469"));
        customerRepository.save(new Customer("CUSTOMER", "Mabel", "Hayes", "jabi@atiruim.bj", "password", "(672) 726-0753", "935 Lejgi Mill", "Pealcu", "NE", "94529", "USA", "348730536505327", "12/19", "765"));
        customerRepository.save(new Customer("CUSTOMER", "Ray", "Cook", "ahmal@imhuk.st", "password", "(273) 387-4479", "1543 Izelef Glen", "Jejhaif", "IL", "58580", "USA", "378649691360463", "09/20", "373"));
        customerRepository.save(new Customer("CUSTOMER", "Ann", "Norton", "asa@ku.gh", "password", "(915) 904-4338", "1607 Tinej River", "Rucmokan", "CT", "41449", "USA", "345009833890333", "10/21", "401"));
        customerRepository.save(new Customer("CUSTOMER", "Frances", "Freeman", "pu@jasfugba.ca", "password", "(481) 984-4533", "895 Dindiz Way", "Reowcil", "NM", "59149", "USA", "349117872154879", "01/23", "392"));
        customerRepository.save(new Customer("CUSTOMER", "Francis", "Hall", "op@zeb.rw", "password", "(732) 758-2229", "181 Kekaz Boulevard", "Vahnamu", "NE", "69978", "USA", "344403230247505", "12/19", "453"));
        customerRepository.save(new Customer("CUSTOMER", "Lillie", "Fernandez", "de@ses.sm", "password", "(795) 737-9303", "317 Vuosa Road", "Ibigevid", "NH", "21606", "USA", "344082039715076", "02/24", "861"));
        customerRepository.save(new Customer("CUSTOMER", "Ruth", "Waters", "vij@jo.sh", "password", "(222) 576-6920", "1757 Lini Way", "Ratosuuki", "ME", "96244", "USA", "5425383509875122", "12/20", "161"));
        customerRepository.save(new Customer("CUSTOMER", "Vincent", "Francis", "pab@egi.py", "password", "(281) 505-8011", "573 Maege Glen", "Fedifarul", "MO", "99025", "USA", "5345943748944729", "09/24", "631"));
        customerRepository.save(new Customer("CUSTOMER", "Steven", "Payne", "biprav@ibzugas.gs", "password", "(929) 291-5527", "1980 Puzwu Path", "Jaupruc", "NY", "78192", "USA", "5244512784517251", "12/19", "382"));
        customerRepository.save(new Customer("CUSTOMER", "Lola", "Grant", "gihiegi@zubisi.sd", "password", "(653) 838-9936", "1962 Horaza Circle", "Fimimi", "OH", "20923", "USA", "5563284673192066", "04/20", "383"));
        customerRepository.save(new Customer("CUSTOMER", "Lilly", "Webb", "vosovog@asu.aw", "password", "(934) 450-5619", "738 Herej Glen", "Ninineki", "RI", "50908", "USA", "5498312386156118", "09/22", "422"));
        customerRepository.save(new Customer("CUSTOMER", "Lucas", "Mendoza", "he@meujopuv.va", "password", "(662) 627-4506", "749 Widso Grove", "Pegiha", "TN", "92255", "USA", "5221772783409275", "01/24", "552"));
        customerRepository.save(new Customer("CUSTOMER", "Cornelia", "Cruz", "oje@iptodwiv.gb", "password", "(256) 512-6352", "713 Doreg Avenue", "Iwekucel", "KY", "12240", "USA", "5548757086997593", "08/23", "282"));
        customerRepository.save(new Customer("CUSTOMER", "Evelyn", "Ramirez", "asepaj@cumjeb.sr", "password", "(906) 798-5464", "550 Dohac Ridge", "Cozfigho", "MT", "90449", "USA", "5555296912442235", "11/19", "208"));
        customerRepository.save(new Customer("CUSTOMER", "Clara", "May", "goteij@zacnefza.ne", "password", "(933) 688-4604", "1671 Pulko Ridge", "Dajiku", "KY", "20742", "USA", "5163976567001063", "12/23", "519"));
        customerRepository.save(new Customer("CUSTOMER", "Nina", "Gibbs", "bakecuw@vugdi.ua", "password", "(359) 405-9077", "1999 Asuim Circle", "Bijjofu", "WI", "61763", "USA", "5459778230716447", "03/22", "387"));
        customerRepository.save(new Customer("CUSTOMER", "Sophie", "Soto", "rek@raw.mc", "password", "(241) 319-8135", "968 Icufiw Junction", "Idfamid", "ME", "85944", "USA", "4190095981042023", "06/24", "604"));
        customerRepository.save(new Customer("CUSTOMER", "Eunice", "Paul", "oke@anaihzes.aw", "password", "(485) 341-8713", "964 Nuiz Boulevard", "Fuljefdi", "HI", "09353", "USA", "4004592635828332", "05/21", "487"));
        customerRepository.save(new Customer("CUSTOMER", "Norman", "Duncan", "usdocdul@caje.lk", "password", "(675) 518-4858", "1971 Magi View", "Gucewer", "AL", "90081", "USA", "4323498482919667", "04/23", "149"));
        customerRepository.save(new Customer("CUSTOMER", "Clyde", "Hardy", "ociro@pusluvdig.cx", "password", "(399) 221-1220", "1150 Homli Turnpike", "Ocguar", "WA", "26810", "USA", "4627254918369966", "04/22", "472"));
        customerRepository.save(new Customer("CUSTOMER", "Roger", "Medina", "fulepo@tipumlom.kh", "password", "(726) 299-9530", "1304 Selulu Way", "Veurfor", "WI", "10850", "USA", "4127668766063832", "12/19", "395"));
        customerRepository.save(new Customer("CUSTOMER", "Garrett", "Bell", "goramu@si.sc", "password", "(391) 880-2310", "1389 Pogow Drive", "Kaupude", "NV", "05613", "USA", "4143046473062878", "11/23", "681"));
        customerRepository.save(new Customer("CUSTOMER", "Mabel", "Tyler", "liwtogu@haris.bo", "password", "(792) 726-6099", "809 Fego Path", "Cudopikap", "AL", "00391", "USA", "4340437363728770", "09/23", "278"));
        customerRepository.save(new Customer("CUSTOMER", "Sadie", "George", "hofaniv@ov.gt", "password", "(884) 283-2463", "1415 Oponu Point", "Ejmigif", "IA", "97851", "USA", "4982271269229200", "03/24", "179"));
        customerRepository.save(new Customer("CUSTOMER", "Jonathan", "Cain", "tavozel@bupkubjas.yt", "password", "(435) 263-0159", "18 Wete Ridge", "Hujoalu", "NM", "36385", "USA", "4022126822107206", "11/21", "698"));
        customerRepository.save(new Customer("CUSTOMER", "Sir", "Wilkins", "wilkins2@gc.com", "password", "(370) 645-4116", "1782 New Address RD", "Jophubro", "AR", "14634", "USA", "4107354232796917", "01/24", "593"));
    }

}
