Mitä algoritmeja ja tietorakenteita toteutat työssäsi

	Toteutan projektissani Huffman-koodauksen sekä siihen tarvittavat tietorakenteet. Huffmanin toimintaa testataan monipuolisesti. Huffmaniin tarvitsee luoda etenkin itse huffman-puu. Tietorakenteena siis tarvitaan solmua. Puuta rakentaessa tarvitsemme tavan järjestää solmuja taajuuksien mukaan, tähän sopivin toteutus on ilmeisesti Prioriteettijono. Merkkien esiintyvyys voidaan tallettaa 256 kokoiseen taulukkoon, indeksi vastaan merkkiä (ASCII) ja arvo esiintyvyyttä. Kooditaulua varten tarvitsemme myös 256 kokoisen taulukon (joka merkille oma), mutta sen sisällä tarvisemme vektoreita tallentamaan bitit. Mahd. ArrayList siis.

Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet

	Valitsin toteutettavaksi Huffman-koodauksen ja mahdollisesti toteutan myös muita tietoa pakkaavia algoritmeja, esim LZW:n. Yritän siis pakata tietoa mahdollisen pieneen tilaan, painottaen lopullisen pakatun tiedoston kokoa suhteessa aika- ja tilavaativuuteen. Yritän oppia vieraasta alueesta (Pakkaaminen, IO, Binääri-operaatiot.. jne) ja saada kasaan mahdollisesti jopa hyödyllisen algoritmin. Prioriteettijono on myös tietorakenne joka jäi itse TiRan aikana vähän epäselväksi. Mukavaa oppia käytännössä. 

Mitä syötteitä ohjelma saa ja miten näitä käytetään

	Ohjelma saa syötteinä lähtö- sekä kohdetiedoston. Lähtötiedostosta luetaan aluksi (tavuina) kaikkien yhdistelmien esiintyvyydet. Esiintyvyyksiä käyttäen algoritmi luo huffman-puun, jota sitten käytetään kooditaulun luomisessa. Kooditaulu sisältää ASCII-merkkien mukaan taulukkoon sijoitetut vastaavat koodatut esitykset. Puu kirjoitetaan erilliseen header-tiedostoon esitettynä ihan puuna Pre-order -järjestyksessä. 0 tarkoittaa: ei lehti ja 1 tarkoittaa kyseisen solmun olevan lehti, luetaan 8 seuraavaa bittiä ja rakennataan puuta samalla sijoittean lehdet sekä muut solmut sinne. Tämän jälkeen kirjoitetaan kooditaulun mukaan, lukien aina tavu kerrallaan lähdetiedostosta, koodatut vastaavat merkit kohdetiedostoon.

Tavoitteena olevat aika- ja tilavaativuudet (m.m. O-analyysit)
	
	Kompressointi:		
		Aika: O(n log n) --- Puun rakentaminen ja tiedoston läpikäyminen muutamaan kertaan.
		Tila: O(n log n) --- Muistissa on itse puu sekä taulukko.

	Dekompressointi:
		Aika: O(n) --- Kunhan puu on valmis, (Luettu yleensä pieni header) voimme suoraan purkaa outputinn yhdellä läpikäynnillä
		Tila: O(log n) --- Tarvitsemme vain puun, jotta voimme purkaa koodin

Lähteet

http://stackoverflow.com/questions/6189765/big-o-complexities-of-algorithms-lzw-and-huffman
http://stackoverflow.com/questions/20319190/what-is-the-running-time-and-space-complexity-of-a-huffman-decode-algorithm
https://en.wikipedia.org/wiki/Huffman_coding
https://www.siggraph.org/education/materials/HyperGraph/video/mpeg/mpegfaq/huffman_tutorial.html
http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/
