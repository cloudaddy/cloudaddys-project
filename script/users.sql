CREATE TABLE `users` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(100) default NULL,
  `address` varchar(255) default NULL,
  `city` varchar(255),
  `state` varchar(50) default NULL,
  `country` varchar(100) default NULL,
  `last_modified` varchar(255),
  `created_on` varchar(255),
  `zip` varchar(10) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `users` (`username`,`email`,`phone`,`address`,`city`,`state`,`country`,`last_modified`,`created_on`,`zip`) VALUES ("Erich Black","Suspendisse.ac.metus@diam.co.uk","1-811-934-2023","Ap #584-5030 Erat Rd.","Coihueco","Biobío","Saint Helena, Ascension and Tristan da Cunha","04/27/16","04/07/15","15598"),("Kasper Burks","nonummy@vel.com","269-8159","129-4797 Cras Rd.","Vitacura","RM","Timor-Leste","12/25/15","12/15/15","50919"),("Brock Burke","lacus.Aliquam.rutrum@non.co.uk","1-253-714-0472","9762 Integer Av.","Hamburg","HH","Bolivia","10/29/15","03/14/17","6813"),("Ishmael Blackwell","elit.pede.malesuada@purusac.net","1-184-843-0443","8895 Enim. St.","Langen","Hesse","Kenya","12/04/15","10/11/16","21817"),("Cadman Patrick","mi.tempor.lorem@porttitorscelerisque.org","1-752-738-8705","804-7159 Dolor, Ave","Lowell","MA","Yemen","08/20/16","05/17/16","76252"),("George Harper","vitae.nibh.Donec@Quisqueliberolacus.org","1-221-836-6199","Ap #528-4344 Magnis Ave","Gore","SI","Algeria","05/24/16","08/13/16","8667"),("Travis Rodgers","facilisis.eget.ipsum@blandit.co.uk","570-3707","175-3120 Nascetur Av.","Uddevalla","O","Paraguay","01/15/16","05/14/15","979388"),("Ryder Dickerson","malesuada@maurisrhoncusid.edu","875-0721","P.O. Box 631, 8174 Purus. Rd.","Nampa","ID","Montenegro","02/20/17","05/16/15","3579"),("Caleb Molina","Integer.tincidunt@sollicitudin.ca","1-972-274-5251","P.O. Box 527, 9993 Ac Avenue","Cunco","IX","Macedonia","08/14/16","02/16/16","99345"),("Kato Duke","nec.imperdiet@disparturientmontes.co.uk","1-905-882-3796","576-2805 Sem Av.","Betim","Minas Gerais","Timor-Leste","08/22/15","03/04/16","63622"),("Knox Benson","eu@Morbi.edu","823-7373","Ap #856-6759 Duis Rd.","Baracaldo","Euskadi","Tonga","06/29/16","12/10/16","83439-979"),("Wade Shields","adipiscing.elit.Etiam@ipsumdolor.net","590-6659","282 Lectus. Street","Berlin","Berlin","Cook Islands","04/24/15","11/30/15","N1L 7Z1"),("Ferris Soto","a.tortor@SedmolestieSed.ca","1-366-511-0695","2743 Magna Avenue","Antibes","PR","Belarus","08/16/16","12/01/15","14913"),("Keane Knight","blandit@actellusSuspendisse.edu","1-784-987-5711","1506 Iaculis Avenue","Huesca","Aragón","Cook Islands","08/09/15","02/07/16","42033"),("Nash Mclaughlin","odio.vel.est@placerat.net","1-467-886-3528","P.O. Box 782, 1765 Suspendisse St.","Presteigne","Radnorshire","Montenegro","04/23/15","10/21/16","8761"),("Isaiah Trujillo","urna@variusNam.edu","891-4744","P.O. Box 718, 1345 Mus. Rd.","Cambridge","Massachusetts","Japan","07/11/15","03/28/17","8046KZ"),("Owen Kirk","Quisque.fringilla@inlobortis.co.uk","1-199-920-9841","189-724 Tellus. Av.","Terzorio","LIG","Equatorial Guinea","07/11/16","01/04/17","30430"),("Peter Gates","hendrerit.id.ante@Nulla.co.uk","1-824-288-0965","Ap #469-8044 Fringilla Street","Bayeux","Paraíba","Luxembourg","02/14/16","09/17/15","58280-322"),("Elmo Dickerson","varius@enimconsequatpurus.ca","747-5172","Ap #234-1171 Etiam Street","Castres","Midi-Pyrénées","Turkey","05/20/16","02/11/16","005129"),("Lucas Simon","elit.dictum@ProinvelitSed.co.uk","998-1594","P.O. Box 133, 6274 Sem, Rd.","Mogi das Cruzes","SP","Jamaica","03/09/17","08/08/15","26-762"),("Tad Skinner","primis.in@pedePraesenteu.co.uk","252-7904","7769 Iaculis, Avenue","Legnica","DS","South Africa","10/23/15","05/19/15","5281"),("Nicholas Flynn","Nunc.mauris.elit@aceleifend.ca","672-0943","Ap #807-9408 Donec St.","St. Clears","CM","Pakistan","07/08/16","09/22/15","Z0I 7KS"),("Patrick Woodard","neque.Nullam@volutpatNulla.co.uk","532-8553","369-2957 Dolor. Rd.","Gebze","Kocaeli","Malta","06/06/15","09/01/16","173081"),("Brett Massey","nisl.arcu.iaculis@arcuiaculis.net","175-8086","P.O. Box 513, 936 Habitant Rd.","Oss","N.","Montserrat","09/14/16","06/27/16","74564"),("Harrison Rodriquez","sed.consequat@egestas.com","339-9963","Ap #257-259 Amet Street","Joué-lès-Tours","Centre","Palestine, State of","03/22/16","12/13/15","46974-493"),("Garrett Rodriquez","id@Inornare.ca","172-4809","344 Sem Ave","Blois","CE","Madagascar","04/04/16","08/08/16","68373"),("Mason Aguirre","diam.Duis.mi@anuncIn.org","455-0765","P.O. Box 699, 544 Pede. Street","Galway","Connacht","Israel","12/15/15","08/11/16","25080"),("Griffith Wilder","sapien@venenatislacus.org","969-0554","P.O. Box 257, 9906 Sed Rd.","Surat","GJ","Azerbaijan","07/04/15","01/25/17","6577KN"),("Armand Russo","sapien.molestie.orci@utnisia.co.uk","1-657-487-5660","4163 Diam Rd.","Belford Roxo","Rio de Janeiro","Denmark","06/14/16","07/12/15","RU50 0AY"),("Calvin Leach","lorem.fringilla@Donecegestas.net","1-824-991-6320","P.O. Box 931, 6145 Nonummy Av.","Murcia","MU","Eritrea","11/11/16","08/05/16","50705"),("Vance Ewing","magnis.dis.parturient@accumsannequeet.org","376-3129","Ap #807-4497 Sapien. St.","Vitrolles","Provence-Alpes-Côte d'Azur","United Kingdom (Great Britain)","06/12/16","07/19/16","73470"),("Rafael Bolton","libero.mauris.aliquam@lobortis.ca","1-951-660-0972","896-7148 Ac, Avenue","Biggleswade","Bedfordshire","Czech Republic","01/28/17","07/22/16","19808"),("Mannix Barrera","ac@dictum.org","1-167-313-5087","P.O. Box 213, 2618 Tellus St.","Deventer","Ov","San Marino","11/01/16","11/12/15","8890MO"),("Thomas Mooney","netus@facilisisSuspendissecommodo.org","1-197-330-4791","790 Quis, Av.","Veere","Zeeland","Oman","03/26/16","04/06/16","41194"),("Herman Whitehead","ut.ipsum@pharetrafeliseget.co.uk","246-9919","943-6070 Arcu Av.","Memphis","TN","Christmas Island","07/14/15","10/20/15","04774"),("Dane Crosby","Sed@mi.org","1-623-535-6874","8152 Eu, St.","Lo Prado","Metropolitana de Santiago","Djibouti","05/18/16","07/09/15","85639"),("Colby Noble","magna.Nam@feugiatnec.com","1-150-969-7666","5257 Tincidunt St.","Contagem","Minas Gerais","Niger","02/09/17","05/26/15","20511"),("Valentine Chang","rhoncus.Nullam@Inscelerisquescelerisque.com","1-675-163-4411","586-2842 Facilisis Rd.","Upper Hutt","North Island","Samoa","07/26/16","11/01/16","3787"),("Jameson Jacobs","ipsum.ac@rhoncus.com","466-9990","Ap #335-7512 Adipiscing St.","Flint","MI","Georgia","11/27/15","06/07/15","8113IE"),("Justin Vang","Duis.gravida.Praesent@dolorvitae.com","1-960-876-6121","7601 Convallis Avenue","Jhansi","Uttar Pradesh","Antarctica","06/22/16","06/29/16","7032"),("Matthew Fernandez","at.auctor.ullamcorper@feliseget.org","1-346-167-5780","Ap #173-9729 Donec Rd.","Breda","N.","Togo","07/16/15","03/01/17","18674"),("Austin Green","mi.lorem.vehicula@Crasegetnisi.com","647-3345","370 At Avenue","Asnières-sur-Seine","IL","Seychelles","05/09/15","10/04/16","V5M 1BG"),("Blaze Dunlap","et.magnis@aliquam.edu","727-6250","P.O. Box 885, 7500 Libero Rd.","North Shore","NI","Central African Republic","12/16/16","04/22/16","61-536"),("Dominic Chase","tincidunt.dui@maurisidsapien.ca","711-2120","Ap #904-4396 Amet, Rd.","St. Thomas","Ontario","Tunisia","10/16/15","04/07/15","6217"),("Marsden Cortez","In@nisidictum.com","894-8425","Ap #153-8604 Ac, St.","Missoula","Montana","Iraq","09/01/16","12/31/15","20069-316"),("James Little","sollicitudin@adipiscingfringilla.ca","893-1251","Ap #114-4429 Est. Avenue","Montague","Prince Edward Island","Djibouti","10/07/16","01/05/16","96115"),("Rahim Chang","facilisis@loremluctus.co.uk","1-347-831-4624","Ap #973-4560 Bibendum Road","Baracaldo","PV","Egypt","11/23/16","11/05/15","X09 3SG"),("Victor Holden","sit@massaMaurisvestibulum.com","119-1534","183-2667 Pulvinar Av.","Kawawachikamach","Quebec","Croatia","06/15/15","12/20/16","53717"),("Len Walters","orci@enim.co.uk","967-2413","3144 Egestas. Road","San José de Alajuela","A","Iraq","08/12/16","03/31/16","371638"),("Damian Cortez","iaculis.aliquet@felisullamcorperviverra.org","1-366-339-5273","5591 Pellentesque Street","Cuceglio","PIE","Tunisia","09/10/15","11/28/15","75-407"),("Mufutau Rich","Maecenas@lobortistellusjusto.org","826-6370","P.O. Box 428, 4815 Aliquam Avenue","Ospedaletto d'Alpinolo","CAM","Guam","05/16/15","09/15/16","5633"),("Kasper Morton","diam.lorem.auctor@pedesagittisaugue.net","1-875-128-1160","Ap #281-1725 Sem, Rd.","San Rafael","C","Australia","03/01/16","12/28/16","3348"),("Phelan Monroe","mauris.eu.elit@Integersem.co.uk","141-6389","4986 Rhoncus. Rd.","Sant'Onofrio","CAL","Indonesia","10/08/15","03/14/16","D8Y 1DF"),("Jordan Hardin","Phasellus.in@magnaPhasellusdolor.edu","1-873-147-2602","823-2926 Arcu Street","Murcia","MU","Madagascar","07/02/15","12/22/16","69757"),("Driscoll Potter","Praesent@vulputateduinec.ca","432-0023","Ap #451-2315 Sociosqu Av.","Cádiz","Andalucía","Switzerland","07/30/16","09/23/15","87263"),("Dexter Reynolds","lacinia.mattis@necenimNunc.org","1-890-489-1937","P.O. Box 406, 5421 Metus. Rd.","Gliwice","SL","Guinea-Bissau","08/06/15","02/18/17","2433"),("Randall Travis","cursus.non@torquentperconubia.co.uk","1-183-234-1073","Ap #318-6290 Sollicitudin Avenue","Olsztyn","Warmińsko-mazurskie","Costa Rica","05/28/15","10/22/16","7145"),("Ira Flores","ipsum.non@nondui.ca","110-5502","601-5504 Etiam Rd.","Mondolfo","MAR","Bermuda","03/22/17","08/03/16","40727"),("Clinton Tran","et.netus.et@idmollis.net","494-7790","7452 Et, Rd.","Sagamu","Ogun","Japan","06/20/15","01/25/16","335697"),("Roth Jackson","enim@sit.edu","1-950-927-9903","P.O. Box 902, 4862 Turpis. St.","Darwin","Northern Territory","Micronesia","01/12/16","05/20/15","V96 8FM"),("Wallace Macias","est@leoinlobortis.com","1-976-317-2750","6463 Molestie Avenue","Vienna","Wie","Djibouti","09/20/16","06/19/16","4194"),("Aaron Leblanc","placerat.eget.venenatis@dictumeu.com","1-778-586-6345","Ap #290-2206 Sit Rd.","Pontevedra","Galicia","Guernsey","01/26/16","01/03/17","L3J 5N2"),("Macaulay Wheeler","Nulla@eu.edu","293-8252","Ap #964-8824 Rutrum Ave","Auckland","North Island","Sweden","10/18/16","10/28/15","34336"),("Garth Jackson","eget@mi.ca","1-438-270-7895","P.O. Box 101, 818 Morbi Rd.","Toruń","KP","Curaçao","12/03/16","10/30/16","756871"),("Sylvester Hayden","conubia.nostra.per@utnisi.ca","1-192-466-7910","789-9992 Semper. St.","Cobourg","ON","Christmas Island","10/22/15","05/29/15","37-982"),("Lewis Chapman","elementum.purus.accumsan@ametrisusDonec.edu","1-854-672-7006","7934 Nec Road","Reading","Pennsylvania","Maldives","01/13/16","10/13/15","5565"),("Fritz Holmes","malesuada.fames@necligulaconsectetuer.ca","1-789-561-4086","P.O. Box 187, 2812 Lacinia Av.","Comox","BC","Jordan","09/20/16","06/29/15","V8R 4V6"),("Sawyer Patton","eget.volutpat.ornare@hendreritaarcu.edu","626-4782","408-8179 Eget Road","Albury","NSW","Sri Lanka","10/26/16","09/14/16","54726"),("Rigel Foster","ipsum.dolor.sit@elementumategestas.ca","854-9266","8293 Morbi Street","Płock","Mazowieckie","Martinique","12/23/16","09/23/15","80200"),("Jasper Gross","litora@egestas.com","242-1700","Ap #712-9530 Ac Street","Gespeg","Quebec","Turks and Caicos Islands","06/26/15","03/22/17","9717QQ"),("Channing Contreras","ac.fermentum.vel@tortorInteger.com","1-390-608-8951","248-3166 Proin Ave","Vienna","Wie","Morocco","10/13/15","11/21/16","FD0 2II"),("Quinlan Valenzuela","laoreet@accumsan.org","1-734-969-2069","984-7600 Nisl. Av.","Ruda","FVG","Guyana","01/30/16","02/13/17","88684"),("Bradley Poole","neque@atlacusQuisque.co.uk","370-2847","Ap #494-2291 Sagittis. Avenue","Piotrków Trybunalski","LD","Jamaica","02/16/17","11/29/15","7348"),("Myles Little","non@Donecporttitortellus.edu","543-2686","5204 Consequat, Avenue","San José de Alajuela","A","Martinique","09/17/16","01/17/16","764542"),("Kennan Harding","in@quis.com","516-2997","Ap #609-7071 Euismod Avenue","Fatehpur","Uttar Pradesh","Norfolk Island","12/15/16","07/20/15","88819-688"),("Lars Yates","sociis.natoque.penatibus@ac.co.uk","217-9578","665-6908 Faucibus Rd.","Ankara","Ankara","Virgin Islands, British","08/12/16","01/31/17","7891"),("Perry Estrada","metus.Aenean.sed@ligulaNullam.co.uk","197-8966","702-4417 Interdum. Avenue","Kelowna","British Columbia","Belgium","04/13/16","12/07/16","36569"),("Jerry Huff","gravida.Aliquam@nibhdolornonummy.net","1-330-540-2093","477-2282 Phasellus Rd.","Laarne","Oost-Vlaanderen","Senegal","10/27/16","09/10/16","49487-026"),("Axel Sheppard","eu.eleifend.nec@porttitorinterdumSed.net","1-961-511-3877","8585 Nascetur Road","Moircy","Luxemburg","Liechtenstein","08/22/15","05/21/15","9463"),("Luke Davenport","non@vitaedolorDonec.co.uk","1-131-553-9543","299-7856 Diam Street","Campbelltown","New South Wales","India","07/20/15","07/10/15","53151"),("Driscoll Hendricks","fames@magnased.com","523-1665","5555 Ipsum Rd.","Rycroft","Alberta","Algeria","03/09/17","09/26/16","04-770"),("Salvador Little","velit@turpis.org","1-167-168-2472","4908 Morbi Street","Berlin","Berlin","Solomon Islands","11/30/15","06/16/15","20359"),("Keefe Pitts","Nunc.ac@eget.ca","746-4872","Ap #930-6262 Gravida. Avenue","Wanganui","North Island","Colombia","03/07/17","10/29/15","01544"),("Neville Ruiz","Nullam.feugiat.placerat@necdiamDuis.com","1-760-652-3757","P.O. Box 472, 9248 Vestibulum St.","Falun","W","Serbia","04/16/16","12/09/16","6365"),("Alan Dillon","Pellentesque.habitant.morbi@nisidictum.edu","963-7101","Ap #397-2173 Accumsan Ave","Helmond","Noord Brabant","Burundi","01/26/16","02/14/17","K99 6GJ"),("Felix Snider","ante@ut.net","147-4053","P.O. Box 354, 7713 Ut Avenue","Diadema","São Paulo","Zimbabwe","11/12/16","08/23/16","518599"),("Erich Cervantes","Integer@id.ca","1-431-661-8828","961-1192 Viverra. St.","Dörtyol","Hat","Dominican Republic","07/18/15","08/23/15","12-149"),("Amal Tucker","Nam@aauctor.co.uk","648-5651","341-335 Fusce Avenue","Perquenco","Araucanía","Bangladesh","11/16/15","08/31/16","5025"),("Cyrus Nichols","vitae@feugiat.edu","217-3903","Ap #730-820 Arcu. Rd.","Saint-Maur-des-Fossés","IL","United States","08/17/16","05/24/15","73729"),("Timon Farmer","Curabitur.ut.odio@ipsum.ca","969-1979","Ap #269-8890 Nulla. Ave","Haverfordwest","Pembrokeshire","Turks and Caicos Islands","04/17/16","08/24/15","11802"),("Benjamin Atkinson","et@vulputate.net","1-234-404-9868","P.O. Box 912, 114 Eu Street","Irricana","AB","Dominican Republic","07/14/15","06/23/16","2605"),("Tyler Haynes","leo.elementum.sem@gravida.net","1-287-140-7186","Ap #768-4228 Molestie Ave","Zele","Oost-Vlaanderen","Zambia","08/13/16","03/04/17","37-604"),("Jerry Barlow","enim.Sed.nulla@auctornuncnulla.co.uk","1-566-621-4521","469-8153 Vivamus Avenue","Skövde","Västra Götalands län","Djibouti","12/08/16","11/16/15","2478"),("Russell Daniels","mollis.Phasellus@venenatisa.ca","887-8186","P.O. Box 956, 3821 Nulla Av.","Zamość","Lubelskie","Dominican Republic","12/30/15","05/03/15","45479"),("Bevis Berg","libero@ipsumSuspendissesagittis.co.uk","1-994-284-4291","P.O. Box 586, 5288 Laoreet St.","Bayeux","Paraíba","Micronesia","01/08/16","11/01/16","S2L 6C2"),("Kamal Mayo","lorem.vitae.odio@Pellentesqueultriciesdignissim.ca","1-931-869-7472","Ap #345-1168 Et Ave","Berlin","BE","Congo, the Democratic Republic of the","08/09/16","02/20/16","79163-345"),("Todd Livingston","feugiat.Lorem.ipsum@dictumplacerataugue.com","334-5783","2454 Ac Rd.","Piotrków Trybunalski","łódzkie","Barbados","11/22/15","09/14/16","4304"),("Cedric Branch","orci.in@Quisqueporttitoreros.net","1-940-824-8331","8142 Sed Avenue","Şereflikoçhisar","Ankara","Egypt","05/21/15","06/28/16","30367"),("Malcolm Mccray","nibh.vulputate.mauris@famesacturpis.org","1-840-441-2754","P.O. Box 266, 4388 Sapien, St.","Alexandria","Dunbartonshire","Guam","01/20/17","12/13/16","52-527"),("Nicholas Horton","lorem.Donec.elementum@iaculis.edu","1-583-327-1493","P.O. Box 794, 7232 Vehicula Rd.","Quilpué","Valparaíso","Kenya","08/09/16","01/04/16","L8B 6C9");
INSERT INTO `users` (`username`,`email`,`phone`,`address`,`city`,`state`,`country`,`last_modified`,`created_on`,`zip`) VALUES ("user","Suspendisse.ac.metus@diam.co.uk","1-811-934-2023","Ap #584-5030 Erat Rd.","Coihueco","Biobío","Saint Helena, Ascension and Tristan da Cunha","04/27/16","04/07/15","15598");

