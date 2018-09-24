package com.forhadmethun.simplesearchapplication;

import com.forhadmethun.simplesearchapplication.developer.DeveloperEntity;
import com.forhadmethun.simplesearchapplication.developer.DeveloperRepository;
import com.forhadmethun.simplesearchapplication.interview.InterviewEntity;
import com.forhadmethun.simplesearchapplication.interview.InterviewRepository;
import com.forhadmethun.simplesearchapplication.language.LanguageEntity;
import com.forhadmethun.simplesearchapplication.language.LanguageRepository;
import com.forhadmethun.simplesearchapplication.programminglanguage.ProgrammingLanguageEntity;
import com.forhadmethun.simplesearchapplication.programminglanguage.ProgrammingLanguageRepository;
import com.forhadmethun.simplesearchapplication.test.BookingRepository;
import com.forhadmethun.simplesearchapplication.test.HotelBookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    private DeveloperRepository developerRepository;

    private LanguageRepository languageRepository;

    private ProgrammingLanguageRepository programmingLanguageRepository;

    private InterviewRepository interviewRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository,
                          DeveloperRepository developerRepository,
                          LanguageRepository languageRepository,
                          ProgrammingLanguageRepository programmingLanguageRepository,
                          InterviewRepository interviewRepository

    ){
        this.bookingRepository = bookingRepository;
        this.developerRepository = developerRepository;
        this.languageRepository = languageRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.interviewRepository = interviewRepository;

    }



    @Override
    public void run(String... args) throws Exception {
        List<HotelBookingEntity> bookings = new ArrayList<>();
        bookings = new ArrayList<>();
        bookings.add(new HotelBookingEntity(1L,"Marriot",200.5,3));
        bookings.add(new HotelBookingEntity(2L,"Bis",90,4));
        bookings.add(new HotelBookingEntity(3L,"Novotr",100.75,1));

        bookingRepository.save(bookings);

        List<InterviewEntity> interviewEntities = new ArrayList<>();
        interviewEntities.add(new InterviewEntity("Software Engineer"));
        interviewEntities.add(new InterviewEntity("Accounts"));
        interviewEntities.add(new InterviewEntity("HR"));
        interviewEntities.add(new InterviewEntity("Guards"));

        interviewRepository.save(interviewEntities);


        List<LanguageEntity> languageEntities  = new ArrayList<>();
        List<ProgrammingLanguageEntity> programmingLanguageEntities = new ArrayList<>();
        List<DeveloperEntity> developerEntities = new ArrayList<>();










        for(int i=0;i<locales.length;i++){
            languageEntities.add(new LanguageEntity(locales[i].toLowerCase()));
        }

        for(int i=0;i<emailList.length;i++){
//            developerEntities.add(new DeveloperEntity(getSaltString(10)+"@gmail.com"));
            developerEntities.add(new DeveloperEntity(emailList[i]));
        }
        for(int i=0;i<programmingLanguages.length;i++){
//            developerEntities.add(new DeveloperEntity(getSaltString(10)+"@gmail.com"));
            programmingLanguageEntities.add(new ProgrammingLanguageEntity(programmingLanguages[i]));
        }
        Random rand = new Random();


//        programmingLanguageRepository.save(programmingLanguageEntities);
//        languageRepository.save(languageEntities);


//
//        List<DeveloperEntity> developerEntities1 = developerRepository.findAll();
//        List<LanguageEntity> languageEntities1 = languageRepository.findAll();
//        List<ProgrammingLanguageEntity> programmingLanguageEntities1 = programmingLanguageRepository.findAll();



        for(int i=0;i<developerEntities.size();i++) {

//            developerRepository.save(developerEntities.get())
            int a = rand.nextInt(programmingLanguageEntities.size());
            int b = rand.nextInt(programmingLanguageEntities.size());
            int max = Math.max(a,b);
            int min = Math.min(a,b);

            int la = rand.nextInt(languageEntities.size());
            int lb = rand.nextInt(languageEntities.size());
            int maxla = Math.max(la,lb);
            int minla = Math.min(la,lb);

            developerEntities.get(i).setProgrammingLanguageEntities(programmingLanguageEntities.subList(min, max));
            System.out.println("maxla-" + maxla);
            System.out.println("maxla-5: " + (maxla-rand.nextInt(5)));
            developerEntities.get(i).setLanguageEntities(languageEntities.subList(maxla-5>0?maxla-rand.nextInt(5):0, maxla));



        }

        for(int i=0;i<programmingLanguageEntities.size();i++){
//            ProgrammingLanguageEntity programmingLanguageEntity = new ProgrammingLanguageEntity(programmingLanguages[i]);
            int a = rand.nextInt(developerEntities.size());
            int b = rand.nextInt(developerEntities.size());
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            if(i%3!=0)programmingLanguageEntities.get(i).setDeveloperEntitiesP(developerEntities.subList(min,max));

//            programmingLanguageEntities.add(programmingLanguageEntity);
        }

        developerRepository.save(developerEntities);
      programmingLanguageRepository.save(programmingLanguageEntities);

      ProgrammingLanguageEntity p1 = new ProgrammingLanguageEntity("LISP");
      ProgrammingLanguageEntity p2 = new ProgrammingLanguageEntity("LUA");
      ProgrammingLanguageEntity p3 = new ProgrammingLanguageEntity("COBOL");
      List<ProgrammingLanguageEntity> programmingLanguageEntities1 =  new ArrayList<>();
      programmingLanguageEntities1.add(p1);
      programmingLanguageEntities1.add(p2);
      programmingLanguageEntities1.add(p3);
      programmingLanguageRepository.save(programmingLanguageEntities1);










/*


        languageEntities.add(new LanguageEntity("en"));
        programmingLanguageEntities.add(new ProgrammingLanguageEntity(1L,"java"));
//        languageRepository.save(languageEntities);
        developerEntities.add(new DeveloperEntity("a@a.a",languageEntities,programmingLanguageEntities));
        programmingLanguageEntities.add(new ProgrammingLanguageEntity(2L,"c"));
        languageEntities.add(new LanguageEntity("bn"));
        developerEntities.add(new DeveloperEntity("b@b.b",languageEntities,programmingLanguageEntities));
        languageEntities.add(new LanguageEntity("jpn"));
        programmingLanguageEntities.add(new ProgrammingLanguageEntity(3L,"php"));
        developerEntities.add(new DeveloperEntity("c@c.c",languageEntities,programmingLanguageEntities));
//        programmingLanguageEntities.get(0).setDeveloperEntitiesP(developerEntities);
        programmingLanguageEntities.get(programmingLanguageEntities.size()-1).setDeveloperEntitiesP(developerEntities);
//        programmingLanguageEntities.get(programmingLanguageEntities.size()-2).setDeveloperEntitiesP(developerEntities);
        programmingLanguageRepository.save(programmingLanguageEntities);
        developerEntities.add(new DeveloperEntity("d@d.d",languageEntities,programmingLanguageEntities));
        developerRepository.save(developerEntities);
//        programmingLanguageEntities.get(0).setDeveloperEntitiesP(developerEntities);
//        programmingLanguageRepository.save(programmingLanguageEntities);



*/





//        programmingLanguageRepository.save(programmingLanguageEntities);





    }
    protected String getSaltString(int size) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < size) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public String[] programmingLanguages = {"o:XML","Oak","Oberon","OBJ2","JAVA","C","C++","ruby","PHP","JS","C#",


            "Object Lisp","ObjectLOGO","Object REXX","Object Pascal","Objective-C","Objective-J","Obliq","OCaml","occam",
            //"occam-π","Octave","OmniMark","Onyx","Opa","Opal","OpenCL","OpenEdge ABL","OPL","OpenVera","OPS5","OptimJ","Orc","ORCA/Modula-2","Oriel","Orwell","Oxygene","Oz","A# .NET","A# (Axiom)","A-0 System","A+","A++","ABAP","ABC","ABC ALGOL","ABSET","ABSYS","ACC","Accent","Ace DASL (Distributed Application Specification Language)","ACL2","ACT-III","Action!","ActionScript","Actor","Ada","Adenine","Agda","Agilent VEE","Agora","AIMMS","Aldor","Alef","ALF","ALGOL 58","ALGOL 60","ALGOL 68","ALGOL W","Alice","Alma-0","AmbientTalk","Amiga E","AMOS","AMPL","AngelScript","Apex (Salesforce.com)","APL","App Inventor for Android's visual block language","AppleScript","APT","Arc","ARexx","Argus","AspectJ","Assembly language","ATS","Ateji PX","AutoHotkey","Autocoder","AutoIt","AutoLISP / Visual LISP","Averest","AWK","Axum","Active Server Pages","B","Babbage","Bash","BASIC","bc","BCPL","BeanShell","Batch (Windows/Dos)","Bertrand","BETA","BLISS","Blockly","BlooP","Boo","Boomerang","Bourne shell (including bash and ksh)","BPEL","Business Basic","C","C--","C++ – ISO/IEC 14882","C*","C# – ISO/IEC 23270","C/AL","Caché ObjectScript","C Shell (csh)","Caml","Calcpad","Cayenne","CDuce","Cecil","Cesil","Céu","Ceylon","CFEngine","Cg","Ch","Chapel","Charity","Charm","CHILL","CHIP-8","chomski","ChucK","Cilk","Citrine","CL (IBM)","Claire","Clarion","Clean","Clipper","CLIPS","CLIST","Clojure","CLU","CMS-2","COBOL – ISO/IEC 1989","CobolScript – COBOL Scripting language","Cobra","CoffeeScript","ColdFusion","COMAL","Combined Programming Language (CPL)","COMIT","Common Intermediate Language (CIL)","Common Lisp (also known as CL)","COMPASS","Component Pascal","Constraint Handling Rules (CHR)","COMTRAN","Cool","Coq","D","DASL (Datapoint's Advanced Systems Language)","Dart","Darwin","DataFlex","Datalog","DATATRIEVE","dBase","dc","DCL","Delphi","DinkC","DIBOL","Dog","Draco","DRAKON","Dylan","DYNAMO","DAX (Data Analysis Expressions)","E","Ease","Easy PL/I","EASYTRIEVE PLUS","eC","ECMAScript","Edinburgh IMP","EGL","Eiffel","ELAN","Elixir","Elm","Emacs Lisp","Emerald","Epigram","EPL (Easy Programming Language)","EPL (Eltron Programming Language)","Erlang","es","Escher","ESPOL","Esterel","Etoys","Euclid","Euler","Euphoria","EusLisp Robot Programming Language","CMS EXEC (EXEC)","EXEC 2","Executable UML","F","F#","F*","Factor","Falcon","Fantom","FAUST","FFP","Fjölnir","FL","Flavors","Flex","FlooP","FLOW-MATIC","FOCAL","FOCUS","FOIL","FORMAC","@Formula","Forth","Fortran – ISO/IEC 1539","Fortress","FoxBase","FoxPro","FP","Franz Lisp","F-ScripF","F#","F*","Factor","Falcon","Fantom","FAUST","FFP","Fjölnir","FL","Flavors","Flex","FlooP","FLOW-MATIC","FOCAL","FOCUS","FOIL","FORMAC","@Formula","Forth","Fortran – ISO/IEC 1539","Fortress","FoxBase","FoxPro","FP","Franz Lisp","F-Script","G","Game Maker Language","GameMonkey Script","GAMS","GAP","G-code","GDScript","Genie","GDL","GJ","GEORGE","GLSL","GNU E","GM","Go","Go!","GOAL","Gödel","Golo","GOM (Good Old Mad)","Google Apps Script","Gosu","GOTRAN","GPSS","GraphTalk","GRASS","Groovy","Hack","HAGGIS","HAL/S","Halide (programming language)","Hamilton C shell","Harbour","Hartmann pipelines","Haskell","Haxe","Hermes","High Level Assembly","HLSL","Hop","Hopscotch","Hope","Hugo","Hume","HyperTalk","Hexa","J","J#","J++","JADE","JAL","Janus (concurrent constraint programming language)","Janus (time-reversible computing programming language)","JASS","Java","JavaScript","JCL","JEAN","Join Java","JOSS","Joule","JOVIAL","Joy","JScript","JScript .NET","JavaFX Script","jq","Julia","Jython","","K","Kaleidoscope","Karel","Karel++","KEE","Kixtart","Klerer-May System","KIF","Kojo","Kotlin","KRC","KRL","KRL (KUKA Robot Language)","KRYPTON","ksh","Kodu","Kv","LabVIEW","Ladder","Lagoona","LANSA","Lasso","LaTeX","Lava","LC-3","Leda","Legoscript","LIL","LilyPond","Limbo","Limnor","LINC","Lingo","LIS","LISA","Lisp – ISO/IEC 13816","Lite-C","Lithe","Little b","LLL","Logo","Logtalk","LotusScript","LPC","LSE","LSL","LiveCode","LiveScript","Lua","Lucid","Lustre","LYaPAS","Lynx","M (alternative name for the MUMPS programming language)","M2001","M4","M#","Machine code","MAD (Michigan Algorithm Decoder)","MAD/I","Magik","Magma","make","Maude system","Maple","MAPPER (now part of BIS)","MARK-IV (now VISION:BUILDER)","Mary","MASM Microsoft Assembly x86","MATH-MATIC","Mathematica","MATLAB","Maxima (see also Macsyma)","Max (Max Msp – Graphical Programming Environment)","MaxScript internal language 3D Studio Max","Maya (MEL)","MDL","Mercury","Mesa","Metafont","MetaQuotes Language (MQL4/MQL5)","MHEG-5 (Interactive TV programming language)","Microcode","MicroScript","MIIS","Milk (programming language)","MIMIC","Mirah","Miranda","MIVA Script","ML","Model 204","Modelica","Modula","Modula-2","Modula-3","Mohol","MOO","Mortran","Mouse","MPD","Mathcad","MSIL – deprecated name for CIL","MSL","MUMPS","MuPAD","Mutan","Mystic Programming Language (MPL)","NASM","Napier88","Neko","Nemerle","nesC","NESL","Net.Data","NetLogo","NetRexx","NewLISP","NEWP","Newspeak","NewtonScript","Nial","Nice","Nickle (NITIN)","Nim","NPL","Not eXactly C (NXC)","Not Quite C (NQC)","NSIS","Nu","NWScript","NXT-G","","o:XML","Oak","Oberon","OBJ2","Object Lisp","ObjectLOGO","Object REXX","Object Pascal","Objective-C","Objective-J","Obliq","OCaml","occam","occam-π","Octave","OmniMark","Onyx","Opa","Opal","OpenCL","OpenEdge ABL","OPL","OpenVera","OPS5","OptimJ","Orc","ORCA/Modula-2","Oriel","Orwell","Oxygene","Oz","P","P4","P′′","ParaSail (programming language)","PARI/GP","Pascal – ISO 7185","PCASTL","PCF","PEARL","PeopleCode","Perl","PDL","Perl 6","Pharo","PHP","Pico","Picolisp","Pict","Pig (programming tool)","Pike","PIKT","PILOT","Pipelines","Pizza","PL-11","PL/0","PL/B","PL/C","PL/I – ISO 6160","PL/M","PL/P","PL/SQL","PL360","PLANC","munoz","Plankalkül","Planner","PLEX","PLEXIL","Plus","POP-11","POP-2","PostScript","PortablE","Powerhouse","PowerBuilder – 4GL GUI application generator from Sybase","PowerShell","PPL","Processing","Processing.js","Prograph","PROIV","Prolog","PROMAL","Promela","PROSE modeling language","PROTEL","ProvideX","Pro*C","Pure","PureBasic","Pure Data","Python","Q (equational programming language)","Q (programming language from Kx Systems)","Q# (Microsoft programming language)","Qalb","QtScript","QuakeC","QPL","R","R++","Racket","RAPID","Rapira","Ratfiv","Ratfor","rc","REBOL","Red","Redcode","REFAL","Reia","REXX","Ring","Rlab","ROOP","RPG","RPL","RSL","RTL/2","Ruby","RuneScript","Rust","S","S2","S3","S-Lang","S-PLUS","SA-C","SabreTalk","SAIL","SALSA","SAM76","SAS","SASL","Sather","Sawzall","SBL","Scala","Scheme","Scilab","Script.NET","Sed","Seed7","Self","SenseTalk","SequenceL","Serpent","SETL","SIMPOL","SIGNAL","SiMPLE","SIMSCRIPT","Simula","Simulink","Singularity","SISAL","SLIP","SMALL","Scratch","Smalltalk","SML","Strongtalk","Snap!","SNOBOL(SPITBOL)","Snowball","SOL","Solidity","SOPHAEROS","SPARK","Speedcode","SPIN","SP/k","SPS","SQL","SQR","Squeak","Squirrel","SR","S/SL","Starlogo","Strand","Stata","Stateflow","Subtext","SuperCollider","SuperTalk","Swift (Apple programming language)","Swift (parallel scripting language)","SYMPL","SystemVerilogT","TACL","TACPOL","TADS","TAL","Tcl","Tea","TECO","TELCOMP","TeX","TEX","TIE","TMG"," compiler-compiler","Tom","TOM","Toi","Topspeed","TPU","Trac","TTM","T-SQL",
//


            "Transcript","TTCN","Turing","TUTOR","TXL","TypeScript","Tynker"};

    String[] locales = Locale.getISOCountries();
    String[] emailList = {"poohpool@signet.com","meixin_kok@hotmail.com","ngai_nicole@hotmail.com","isabelle_gal@hotmail.com","michelle-878@hotmail.com","valerietan98@gmail.com","remuskan@hotmail.com","genevieve.goh@hotmail.com","poonzheng5798@yahoo.com","burgergirl96@hotmail.com","insyirah_powergals@hotmail.com","little_princess-angel@hotmail.com","ifah_duff@hotmail.com"
,"tweety_butt@hotmail.com","choco_ela@hotmail.com","princessdyanah@hotmail.com","isabelle_gal@hotmail.com","choco_ela@hotmail.com","tweety_butt@hotmail.com","emotionallady_94@hotmail.com","weiheng1998@yahoo.com.sg","nas_wify011005@hotmail.com","issabelle_gal@hotmail.com","zihah_lovepurple@hotmail.com","adeline-98@hotmail.com","ifah_duff@hotmail.com","fionachiwei@hotmail.com","frens_luv_sad_hatred@hotmail.com","clara1_wong@hotmail.com","burgergirl96@gmail.com","princess_dyanah@hotmail.com","a_qilah@hotmail.com","genevieve.goh@hotmail.com","ngai_nicole@hotmail.com","anisah2511@yahoo.com.sg","arissaardianty@yahoo.com.sg","kid_diyanah@hotmail.com","little_princess-angel@hotmail.com","aniqah1303@yahoo.com.sg","nur-filzah@hotmail.com","th3_finalez@hotmail.com","insyirah_powergals@hotmail.com","kfc_96@hotmail.com","add_friend@mail.friendster.com","pinky_omek@hotmail.com","alicia-0809@hotmail.com","oeighto@gmail.com","dareenpuff@hotmail.com","fatin_danial@hotmail.com","goodyme@hotmail.com","natasha_gal_0407@hotmail.com","nur_ashikin_90@hotmail.com","bluebear_mas66@hotmail.com","chocsfreaksme_fiza@hotmail.com"
//,"redgurlz_3@hotmail.com","faith_awsome85@yahoo.com","nita_cutie@hotmail.com","nur-filzah@hotmail.com","pwincess_pink97@hotmail.com","quik_boi93@hotmail.com","winter_times@hotmail.com","xuanji06@hotmail.com","issabelle_gal@hotmail.com","tweety_butt@hotmail.com","kkshrestha@hotmail.com","sammysamrat@hotmail.com","thakursantu@hotmail.com","tararegmi1@hotmail.com","gaurav_sumit@hotmail.com","preetyshrestha@hotmail.com","sureshrana23@hotmail.com","deepubhandari75@hotmail.com","shyam_shundar@hotmail.com","rajanupreti@hotmail.com","sachhi52@hotmail.com","subashgauttam@hotmail.com","tej_nv@hotmail.com","khan_golden@hotmail.com","santoshlama7@hotmail.com","govinda_kavre@hotmail.com","justchill_005@hotmail.com","rafee90@hotmail.com","htrahddis@hotmail.com","dn_thapa@hotmail.com","thepunkrocks_rajiv@hotmail.com","mountain_201@hotmail.com","sweetprati@hotmail.com","ramulama_bamjan@hotmail.com","sumi_tamang@hotmail.com","sag_sameer@hotmail.com","dahalsalik@hotmail.com","puja_shakya@hotmail.com","sujata@hotmail.com","pravalghimire@hotmail.com","adhikari_bipin@hotmail.com","archana_kali@hotmail.com","dickey_143@hotmail.com","hazygal@hotmail.com","koi_dil@hotmail.com","nitiaryal@hotmail.com","pratimaaryal@hotmail.com","uncleargal@hotmail.com","me_sweetanu@hotmail.com","remix_143@hotmail.com","rupak007@hotmail.com","dipesh_87@hotmail.com","annsue58@hotmail.com","bikash_devkota@hotmail.com","simon143_me@hotmail.com","matesanjay@hotmail.com","sudip_pkr@hotmail.com","anshikachand@hotmail.com","the_anu@hotmail.com","me_sweetanu@hotmail.com","uncleargal@hotmail.com","aryalranjan@hotmail.com","barsartu_regmi@yahoo.com","worldstar_17@hotmail.com","adhikari_bipin@hotmail.com","thepramita@hotmail.com","pratiksharyal@hotmail.com","caruso_sidney@hotmail.com","sari_kc2000@yahoo.com","bhanu_aryal2003@yahoo.com","sharma_423@hotmail.com","phurke@hotmail.com","pratimaaryal@hotmail.com","silwalraju51@hotmail.com","iglootours@wlink.com.np","rosharani@yahoo.com","pandeyshankar@yahoo.com","pathakgeminy@hotmail.com","thapaliausha@yahoo.com","thapaliausha@hotmail.com","enggvishnu@hotmail.com","kamal_lg@hotmail.com","asigdel@msn.com","rachaelgreen@hotmail.com","sagun47@hotmail.com","dearraghu@hotmail.com","thupslama@hotmail.com","dhakal_lp@hotmail.com","dilipkaphle@yahoo.com","savimiss@hotmail.com","salpa77@hotmail.com","sagar_007np@hotmail.com","nabin30@hotmail.com","shubhakamana853@hotmail.com","narayanpandey99@hotmail.com","phurke@hotmail.com","rickyl2599@hotmail.com","parajuli2005@hotmail.com","drgajurel@hotmail.com","achyut55@hotmail.com","bedgautam@hotmail.com","bhetghat@msn.com","bijay.jasawal@gmail.com","basnetbikash@yahoo.com","binita_5@hotmail.com","chanda_sis@hotmail.com","chintan_dhungel@hotmail.com","crys_aastha@hotmail.com","khatiwada25@hotmail.com","indira_rimal@hotmail.com","jchudal@hotmail.com","joshi_muna@hotmail.com","kabita_rai21@hotmail.com","akela_raj@hotmail.com","aylin.ustguney22@hotmail.com","bhugiri@hotmail.com","damansondhi@hotmail.com","freeleoo@hotmail.com","gautam_pkr@hotmail.com","kentala@live.com","krishna@itsoft.com.np","kuldipsoor@gmail.com","kuldipsoor@yahoo.ca","poudeldeepak@hotmail.com","r_seker61@hotmail.com","prem_sang@hotmail.com","praveen_121@hotmail.com","rambabu92000@hotmail.com","rabisharma@hotmail.com","200604281855.k3slt65c005757@nit.isi.edu","ietf-announce@domain.hidden","rfc-editor@domain.hidden","ietf-announce-request@ietf.org","ietf-announce@ietf.org","adoi-press-l-subscribe-request@list.id.state.az.us","adoi-bulletin-l-subscribe-request@lists.id.state.az.us","adoi-newsletter-l-subscribe-request@lists.id.state.az.us","200604281854.k3slstfr005720@nit.isi.edu","200604281855.k3sitckc005762@nit.isi.edu","bca@brandermill.com","200604281854.k3sisilk005715@nit.isi.edu","ipv6@domain.hidden","info@i-netsolution.com","ietf-announce-owner@ietf.org","abc1234@tntech.edu","kaythume@tntech.edu","rcashion@tntech.edu","ewells@tntech.edu","w32dasn@cox.net","listname-help@example.org","username@host.tld","listname-info@example.org","listname-faq@example.org","listname-subscribe@example.org","listname-unsubscribe@example.org","listname-digest-subscribe@example.org","listname-digest-unsubscribe@example.org","host.tld@example.org","listname-get.123_145@example.org","listname-index.123_456@example.org","listname-thread.12345@example.org","listname-owner@example.org","mla@mla-india.com","ducky@webfoot.com","mabel@flossresearch.com","mabel.garcia@flossresearch.com","garcia@flossresearch.com","info@sutletgroup.com","info@rigginglifting.com","link@thefloridadesigngroup.com","america@rigginglifting.com","european@rigginglifting.com","worldwide@rigginglifting.com","tech@rigginglifting.com","aftersale@rigginglifting.com","dbishop103@darlenebishop.com","thaisgp@singnet.com.sg","sharmadeep007@gmail.com","steve@dlendinggroup.com","webmitress@verysinful.com","info@thefloridadesigngroup.com","mtl@mtlgroup.com","careers@thefloridadesigngroup.com","info@sagedesigngroup.com","news@mashable.com","advertising@mashable.com","events@mashable.com","bizdev@mashable.com","jobs@mashable.com","contact@mashable.com","links@management-advantage.com","scouden@pacbell.net","info@management-advantage.com","directory@zeen.com","design@homeplangroup.com","information@asrec.co.uk","sales@audiobuys.net","info@expeditemg.com","legal@sutletgroup.com","accounting@sutletgroup.com","promotion@sutletgroup.com","trading@sutletgroup.com","assistance@veteranlove.com","toni@veteranlove.com","charlene@veteranlove.com","craig@veteranlove.com","jonathan@veteranlove.com","dan@veteranlove.com","mario@veteranlove.com,info@justnorth.com","garlandofroses@gmail.com","sales@linkbuildingsolution.com","superman577373@yahoo.com","jpfellwock@yahoo.com","pattimace@sbcglobal.net","sales@websource.co.in","sales@websourceeurope.com,sales@websourcepacific.com","sales@websourceasia.com.sg","rohit.z.ghosh@something.com","jack.z.welsh@something.com","dan.z.gaul@something.com","marc.h.bricman@something.com","sally.m.fields@something.com","fred_g_manning@something.com","susan.kayman@something.com","susana.virginis@something.com","gale_t_richards@something.com","steve0rourke@something.com","briggs@something.com","wiley.p.reddington@something.com","amy.n.roy@something.com","ebusinessindya@gmail.com","noreply@trendmicro.com","bizzebee_xp@yahoo.com","net@websource.co.in","sse@websource.co.in","swd@websource.co.in","jobs@websource.co.in","info@rupizxpress.com","mla@mla-india.com","sales@johnsplace.com","jack69business@gmail.com","alexwong10@hotmail.com","annitse@hotmail.com","caleb_calcar@hotmail.com","bwn_0964@hotmail.com","brendan_7667@hotmail.com","blurboy5391@hotmail.com","bestfriendsforever_1997@hotmail.com","chatty324@hotmail.com","footprint_starpint@hotmail.com","fiona_lee_92@hotmail.com","felicia_zhiling@hotmail.com","goodbyesucker@msn.com","gemini_girl_hihi@hotmail.com","i_rawkforeva@hotmail.com","hollywoodstreet_1981@hotmail.com","hiroshima_akawashi@hotmail.com","hidayah_billabong@hotmail.com","leafz19@hotmail.com","kimyan007@hotmail.com","ngbionicle@hotmail.com","masterdon2002@hotmail.com","mad_halo@hotmail.com","smileyy_jan@hotmail.com","ridhwan_5@hotmail.com","rainsnow@myself.com","tin_443@hotmail.com","thy_93@hotmail.com","teoxm91@hotmail.com","yh_musicunlimited4life@hotmail.com","yrnchan@hotmail.com","baoyue_8@hotmail.com","a_afiqah_mj@hotmail.com","sweetichickz@hotmail.com","amalina_rawk_76@hotmail.com","hazyrah@hotmail.com","ifarisha@hotmail.com","kohrongyipamela@hotmail.com","koolkitty_1997@msn.com","lizzie_mcguire_acnes@hotmail.com","maythae@hotmail.com","miragomez_95@hotmail.com","roxy_girl79@hotmail.com","adahuys95@hotmail.com","andyqa_95@hotmail.com","coolhaz_96@hotmail.com","cybergirl_v1997@hotmail.com","fortytwo_test5@hotmail.com","hairul_blueice21@hotmail.com","ifarisha@hotmail.com","rani_cuties.fah@hotmail.com","k_rina97@hotmail.com","nur_love27@hotmail.com","iduncare_11@hotmail.com","koolkitty_1997@msn.com","maythae@hotmail.com","mhb9523@hotmail.com","miza626@hotmail.com","mysteryguy_unknown007@hotmail.com","nicole_wpw@hotmail.com","kohrongyipamela@hotmail.com","a_afiqah_mj@hotmail.com","afiq_crazy@hotmail.com","amalina_rawk_76@hotmail.com","andyqa_95@hotmail.com","un_atren@hotmail.com","bmbpgirl@hotmail.com","boi_boi95@hotmail.com","danial_liverpool@hotmail.com","danish_syafiq@hotmail.com","earth_girl_rule@hotmail.com","elitefighter_10@hotmail.com","hamster_gurl95@hotmail.com","hard_tu_understand@hotmail.com","myrah_diamond17@hotmail.com","kacheek_95@hotmail.com","miragomez_95@hotmail.com","nabil_mysterio@hotmail.com","nabilah_blue77@hotmail.com","nasiruddin_makan@hotmail.com","nisa_boop08@hotmail.com","nur_love27@hotmail.com","nutty.choco@hotmail.com","paris32116@hotmail.com","princessfatin@hotmail.com","roxy948_mirah@hotmail.com","syazwany_95@hotmail.com","spongeybabygal@hotmail.com","syahsyah_05@hotmail.com","xiao_boy95@hotmail.com","iddodo@hotmail.com","xiongjingks@hotmail.com","hayati619@hotmail.com","muhd_zul@hotmail.com","aiksoon159@hotmail.com","aman.jr@hotmail.com","ameerul_cool@hotmail.com","azmoz91@hotmail.com","babypiglet_cutie@hotmail.com","farahain_hamid@hotmail.com","fifi_fifah@hotmail.com","iqah_maddie@hotmail.com","hazrol_realmadrid@hotmail.com","lam_huimin@hotmail.com","minyi0324@hotmail.com","peacegianna@hotmail.com","yjin4394@hotmail.com","shobu_27@hotmail.com","adira_naz@hotmail.com","afifah_may15@hotmail.com","ah_belle@hotmail.com","bmbpgirl@hotmail.com","dip_gerl94@hotmail.com","devilia92@hotmail.com","emily_gerl94@hotmail.com","fifi_fifah@hotmail.com","hannah-the-gerl94@hotmail.com","hurul_aiin@hotmail.com","kaizah_kazana@hotmail.com","lil_blue_yana@hotmail.com","emily_gerl94@hotmail.com","aqiillah.-@hotmail.com","joyah_co@hotmail.com","fifah_paradise96@hotmail.com","ah_belle@hotmail.com","han_emogurl@hotmail.com","huimin_poppies@hotmail.com","jing_lei94@hotmail.com","kaizah_kazana@hotmail.com","kianna_23@hotmail.com","princess_nat@hotmail.com","white_butterflywings@hotmail.com","realitygerl22@hotmail.com","relitygirl@hotmail.com","serene041094@hotmail.com","siti_sharmila08@hotmail.com","xiiaobabyyboii@hotmail.com","xiiaonana-@hotmail.com","singapore_7@hotmail.com","korea_rox_johnnybravo@hotmail.com","staryyskyy_craziieboutyuu@hotmail.com","music_rocks_life@hotmail.com","littlekitty1995@hotmail.com","liliumangel@hotmail.com","baby-felicia@hotmail.com","luck_angel579@hotmail.com","andrea_starlight@hotmail.com","joeywengshuyi@hotmail.com","piglet_en@hotmail.com","yeo_bernita@hotmail.com","sarah_hqm@hotmail.com","myiie_worldd@hotmail.com","blackpeaz@hotmail.com","ecclesiachang@hotmail.com","xiia0_@hotmail.com","evan_friendz@hotmail.com","lookwhosenuts@hotmail.com","thamsooklai@hotmail.com","rayow44@hotmail.com","dawn_lyw@hotmail.com","axpt1@hotmail.com","hweejia95@hotmail.com","blueishgurl@hotmail.com","sheryl817@hotmail.com","hamsterlove_queen@hotmail.com","tan_wan_xuan@hotmail.com","opgal_vanessa@hotmail.com","luckiness_celine@hotmail.com","piggysleeping123@hotmail.com","kymberly_jaychourox@hotmail.com","bluedogs_alf@hotmail.com","na_greennpink_sassygirl@hotmail.com","ariesbaby_ilurveyou@hotmail.com","nikeshoe11@hotmail.com","dancefreak_jnlx@hotmail.com","forbidden-illusions@hotmail.com","ygjx12345_@hotmail.com","love_destiinygal@hotmail.com","angelkwan108@hotmail.com;angie@sai.sg","angelkwan108@hotmail.com","andria_fairy@hotmail.com","andrea.starlight@hotmail.com","aprecole@hotmail.com","ariesbaby_ilurveyou@hotmail.com","askgarage@yahoo.com","blueishgurl@hotmail.com","blackpeaz@hotmail.com","baby-felicia@hotmail.com","axpt1@hotmail.com","carlota_110@hotmail.com","btabth@hotmail.com","cherisgoh@yahoo.com.sg","chchyr@yahoo.com.sg","chrischew50@hotmail.com","dark_kitty_26@hotmail.com","dennislee_82@msn.com","doris@smartcardcentre.com","coconania@hotmail.com","ellen.77@hotmail.co.uk","ellen.77@hotmail.com","evetan5@yahoo.com.sg","jasalibart@hotmail.co.uk","jlie@nsl.com.sg","joeywengshuyi@hotmail.com","kahsiok@yahoo.com.sg","kaz_alice_@hotmail.com","kitty_117sg@hotmail.com","korea_rox_johnnybravo@hotmail.com","xoo-b34n5-oox@hotmail.co.uk","ecclesiachang@hotmail.com","hotbabe000@hotmail.co.uk","coconania@hotmail.com","james5996@hotmail.co.uk","jamierobs@hotmail.co.uk","karate-kid-1995@hotmail.com;dnomyar25@hotmail.com","ernest_1997@hotmail.com","frisbeemin@hotmail.com","isabelsia@hotmail.com","james_pokemon@hotmail.com","jeremytan509@hotmail.com","jingyi_100_j@hotmail.com","mikesia98@hotmail.com","nfscxoss@hotmail.com","pethamster-@hotmail.com","grace_niebrown@hotmail.com","unik_galz@hotmail.com","valenciayrq@gmail.com","xiiao-gurl@hotmail.com","xiiaokiwi@hotmail.com","yaronlim@hotmail.com","shandelzare_silkwood_92@hotmail.com","zhixin1097@hotmail.com","pcailing@hotmail.com","apple_felicia@hotmail.com","carmenkoh97@hotmail.com","xiaojie_charis@hotmail.com","charlotte_jw@hotmail.com","charmainekoh99@hotmail.com","cherie_jt@hotmail.com","chesnachin@hotmail.com","crazy_me_366@hotmail.com","francisngjc@hotmail.com","enimsaj_me@hotmail.com","faithoh@hotmail.com","frisbeemin@hotmail.com","thierry_henry@hotmail.com","isabelvtan@hotmail.com","winx_tohyy@yahoo.com.sg","james_pokemon@hotmail.com","jamieng94@hotmail.com","snoopyjas@hotmail.com","junelo81@hotmail.com","kimberlytoh97@hotmail.com","pethamster-@hotmail.com","sucrebonbon@hotmail.com","swan_53@hotmail.com","vane55a_goh@hotmail.com","xiiao-gurl@hotmail.com","yanxi_97@hotmail.com","yaronlim@hotmail.com","tan_yingjin@hotmail.com","zhixin1097@hotmail.com","dear_linda_akasyah@hotmail.com","babyskiie_95@hotmail.com","caleb_hoe@hotmail.com","charlotte_jw@hotmail.com","claricebutterfly@hotmail.com","graceful_dolphins@hotmail.com","hamtaro3344@hotmail.com","ianwong24@hotmail.com","isabelvtan@hotmail.com","jainuslee@hotmail.com","jolenerox@hotmail.com","mystery_punk@hotmail.com","meowoz_113@hotmail.com","pethamster-@hotmail.com","ff_raisha2@yahoo.com.sg","raudhah_tul_jannah@hotmail.com","sheryl8koh@hotmail.com","tan_yingjin@hotmail.com","tiffanytanmin@hotmail.com","val0729@hotmail.com","weekaris_123@hotmail.com","weibin_1996@hotmail.com","weilun_1997@hotmail.com","winx_bloom2005@hotmail.com","xiiaokiwi@hotmail.com","xxlordzxx@hotmail.com","angie_5_november_96@hotmail.com","angiedoggie@gmail.com","angielau1996@hotmail.com","annalisa1996@hotmail.com","ayuni_coolgal@hotmail.com","ayuuuni@hotmail.com","babyzpups@hotmail.com","celchia@hotmail.com","charlotte_jw@hotmail.com","cherie_jt@hotmail.com","csjw_8@hotmail.com","cuimei88@hotmail.com","cute_babypie@yahoo.com.sg","dogz_rawkz@hotmail.com","eunice_yee@singnet.com.sg","faithchan678@hotmail.com","gohzhengwei758@hotmail.com","huangxi-ao@hotmail.com","inachia@hotmail.com","jasmine_tinkle_snowynite@hotmail.com","jasminetantianxin@hotmail.com","jinyi1996@hotmail.com","kaiwen_999@hotmail.com","kallista_libra@hotmail.com","lim_zhen_yang@hotmail.com","nini839839@hotmail.com","nur_sabrina5c@hotmail.com","ranchel_ljm@hotmail.com","rinharikoma@hotmail.com","salintonjadeprincess@hotmail.com","sam_wordsab@hotmail.com","sillycupid_hx@hotmail.com","talticia@hotmail.com","tris288@hotmail.com","vincentwong2188@yahoo.com.sg","vincentwys2188@hotmail.com","xiaopuppie@hotmail.com","tiaraamalina@hotmail.com","jujulee0709@hotmail.com","precious_memo_0808@hotmail.com","lorainengwanting@hotmail.com","lynn94ng@hotmail.com","darren_tan_@hotmail.com","dogz_rawkz@hotmail.com","meowoz_113@hotmail.com","nurulazila@hotmail.com","real_human1996@hotmail.com","xiia0miimii@hotmail.com","racon_brown@hotmail.com","lml_1120@hotmail.com","horjoin@hotmail.com","jiayilow@hotmail.com","fantasy_celine@hotmail.com","prideofagirl@hotmail.com","tammychloe_95@hotmail.com","lorainengwanting@hotmail.com","chelseaco@hotmail.com","jilljeantoh288@msn.com","leesunliew@hotmail.com","darren_tan_@hotmail.com","ripcurl_gal321@hotmail.com","miskiah_so_cute@hotmail.com","vanessa_blue_dolphin@hotmail.com","cleric_mage45@hotmail.com","tuti_princess@msn.com","xiia0miimii@hotmail.com","rachel_tay1996@hotmail.com","jujulee0709@hotmail.com","anna_hi.friends@hotmail.com","deahauxiel@hotmail.com","davidabigailrae@hotmail.com","foo.jane@hotmail.com","nini839839@hotmail.com","be_happy_1996@hotmail.com","joyce_inlove5646@hotmail.com","aaronlsl@hotmail.com","beast_boy96@hotmail.com","rabbit343@hotmail.com","june_ling_1996@msn.com","gothic_rose12@hotmail.com","lance-co@hotmail.com","life_sux_with_kathleen@hotmail.com","totally-freaked@hotmail.com","blueviolin15@hotmail.com","blue_tiny_wave@hotmail.com","fallen.destiny@hotmail.com","aaronlsl@hotmail.com","amirah_nazri@hotmail.com","anna_hi.friends@hotmail.com","chelseaco@hotmail.com","davidabigailrae@hotmail.com","deahauxiel@hotmail.com","linkin_butt@hotmail.com","germaine_lim@hotmail.com","jingen96@hotmail.com","beast_boy96@hotmail.com","joh_linn@hotmail.com","charmaine_lim@hotmail.com","life_sux_with_kathleen@hotmail.com","miskiah_so_cute@hotmail.com","pets_lurver@hotmail.com","precious_memo_0808@hotmail.com","rachel_tay1996@hotmail.com","strawberry_kissme@hotmail.com","totally-freaked@hotmail.com","tryphena_wong@hotmail.com","vanessa_blue_dolphin@hotmail.com","weiying94@hotmail.com","zenghou@hotmail.com","anna_hi.friends@hotmail.com","anna_thatgirl@hotmail.com","beast_boy96@hotmail.com","botak_boy@hotmail.com","chingyih88888888@hotmail.com","darkzenz@hotmail.com","darrelcbw@hotmail.com","eddy_1507@hotmail.com","garde_nana@hotmail.com","glittersapphire@hotmail.com","crazylazygracie@hotmail.com","ivan.zylim@hotmail.com","jiayi1995@hotmail.com","jingen96@hotmail.com","jodi_choo@hotmail.com","leekellie@yahoo.com.sg","leecolleen@yahoo.com.sg","kyogresoh_07@hotmail.com","kian_xiong@hotmail.com","june_ling_1996@msn.com","anna_hi.friends@hotmail.com","baby-angel-love-it@hotmail.com","casurina_heng@hotmail.com","chocolate548@hotmail.com","clover_lover_94@hotmail.com","jingen96@hotmail.com","lawbreaker96@hotmail.com","limpq@hotmail.com","ngjuileng@hotmail.com","precious_pups@hotmail.com","seeonn1@hotmail.com","shi_jie_510@hotmail.com","wanping_wp@hotmail.com","snow-angel-2303@hotmail.com","charis_galrox@hotmail.com","wei-qi125@hotmail.com","pretzocheeze@hotmail.com","ng_zhen_feng@hotmail.com","matthewcyj@hotmail.com","lmj1801@hotmail.com","leejiayingjy@hotmail.com","leeguoguohui@hotmail.com","lakumao@hotmail.com","josiah-1-2-3@hotmail.com","jolyn_ang96@hotmail.com","jia_amelia12@hotmail.com","incredible96@hotmail.com","emir_hamzah555@hotmail.com","death-awaits@hotmail.com","angel_wings_star@hotmail.com","cute_cuppycake96@hotmail.com","benz9221@hotmail.com","first-sign-of-l0ve@hotmail.com","ilovemydogyogi@hotmail.com","jannah68@hotmail.com","kopeng197@hotmail.com","mejlpx_17nb@hotmail.com","ong_weiting@hotmail.com","pinky_dolfin@hotmail.com","sweetysha_@hotmail.com","the_pincher@hotmail.com","wanping_wp@hotmail.com","yiyi_girl_7@hotmail.com"

            ,"yipeex_0408@hotmail.com","yu_xuan_999@hotmail.com","agent_mankim@hotmail.com"};


}
