Ohjelman yleisrakenne

Ohjelma muodostuu kahdesta projektista (sovulluksesta), kummallakin ovat omat luokkansa. Moni luokista on vastaavia, en osannut toteuttaa kahta terminalista käytettävää samaan ohjelmaan. 

Luokat: (HuffmanCompress)

-HuffmanCompress
	Sisältää algoritmin toiminnan. Main. Luokassa on myös muutama tarvittava metodi, kuten getFrequencies, joka rakentaa taulukon esiintyvyyksille, ja writeHeader, joka kirjoitattaa tiedostolle Headerin, jossa kuvataan huffman-puun rakenne.	
-In
	Käyttää javan InputStreamia, mutta käsittelee tavun kerrallaan ja mahdollistaa näin työskentelyn bittien parissa tavun sisältäkin.
-Out
	Käyttää javan Outputstreamia, käsittelee ennen tiedostoon kirjoittamista tavun bitti kerrallaan, mahdollistaa bittien parissa työskentelyn.
-CodeTable
	Luokka johon on tallennettu kooditaulukko, eli koodaus jokaiselle merkille, käytetään kohdetiedostoon kirjoittamisen yhteydessä. Sisältää metodin build, jolla taulukko luodaan huffman-puusta, saaden syötteenä juuren.
-Frequencies
	Sisältää taulukon merkkien esiintyvyyksistä, joka luotiin mainissa. Tärkein metodi (ainoa tärkeä) on buildTree, joka rakentaa huffman-puun esiintyvyyksien mukaan ja palauttaa juuren.
-Node
	Tietorakenne puuta varten. Joka solmulla on oma Character (tai '\0'), vasen ja oikea lapsi (tai null) sekä esiintyvyys (tai lapsien esiintyvyyksien summa).
-OwnArrayList
	Oma yritys ArrayListin luomiseen. Luokka on tällä hetkellä poissa käytöstä, sillä en saanut sinne tallennettuja integerejä muotoon integer enää muodon object jälkeen.
-PQ
	Prioriteettijono. Käyttää minimikekoa järjestelläkseen alkioita 'jonossa.'

Decompress:

-Decompress
	Pääluokka, joka vastaa miltei kaikesta toiminnallisesta. Määrittää lähde- ja kohdetiedoston, metodi readHeader lukee rekursiivisesti Headerin ja näin pystyy rakentamaan puun, jota sitä käytetään heti koodatun tiedoston purkamiseen.
-In
	Käyttää javan InputStreamia, mutta käsittelee tavun kerrallaan ja mahdollistaa näin työskentelyn bittien parissa tavun sisältäkin.
-Out
	Käyttää javan Outputstreamia, käsittelee ennen tiedostoon kirjoittamista tavun bitti kerrallaan, mahdollistaa bittien parissa työskentelyn.
-Node
	Tietorakenne puuta varten. Joka solmulla on oma Character (tai '\0'), vasen ja oikea lapsi (tai null) sekä esiintyvyys (tai lapsien esiintyvyyksien summa).	

Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista)


Suorituskyky- ja O-analyysivertailu (mikäli työ vertailupainotteinen)
	Compress

	Aika: O(n log n) - Lukee tiedoston kahteen kertaan, rakentaa yksiulotteisen taulukon. Rakentaa sekä lukee puun.
	Tila: (n log n) -||-
	
	Decompress

	Aika: O(n) -- Lukee pienen headerin rakentaa puun, purkaa tiedoston yhdellä läpikäynnillä. 
	Tila: O(log n) -- Puu tallentuu.
Työn mahdolliset puutteet ja parannusehdotukset

	Olisin todellakin halunnut saanu tietorakeenteeni toimimaan. En ymmärrä kuinka toteuttaa ArrayListin <> !nämä. LZW olisi ollut hauska toteuttaa, Trie kuulostaa hauskalta. Koodia voisi siistiä ja IO:n toteuttaa varmaan järkevämminkin. Kaikin puolin haluaisin paneutua projektii enemmänkin. 

Lähteet
http://stackoverflow.com/questions/6189765/big-o-complexities-of-algorithms-lzw-and-huffman
http://stackoverflow.com/questions/20319190/what-is-the-running-time-and-space-complexity-of-a-huffman-decode-algorithm
https://en.wikipedia.org/wiki/Huffman_coding
https://www.siggraph.org/education/materials/HyperGraph/video/mpeg/mpegfaq/huffman_tutorial.html
http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/
