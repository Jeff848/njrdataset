package sitsiplaseeraus.random;

import omatTietorakenteet.ArrayList;

/**
 * Sisältää miehen etunimiä
 */
public class EtunimetMiehen{

    ArrayList<String> etunimet;

    /**
     * Alustaa käyttöön
     */
    public EtunimetMiehen() {
        etunimet = new ArrayList<String>();
        this.lisaaEtunimet();
    }

    /**
     * Palauttaa satunnaisen etunimen
     * @return Miehen etunimen
     */
    public String palautaEtunimi() {
        int koko = this.etunimet.size();
        int random = Random.luo(koko - 1);
        return this.etunimet.get(random);
    }

    private void lisaaEtunimet() {
        etunimet.add("Aadolf");
        etunimet.add("Aapeli");
        etunimet.add("Aapo");
        etunimet.add("Aappo");
        etunimet.add("Aarne");
        etunimet.add("Aarni");
        etunimet.add("Aarno");
        etunimet.add("Aaro");
        etunimet.add("Aaron");
        etunimet.add("Aarre");
        etunimet.add("Aarto");
        etunimet.add("Aatami");
        etunimet.add("Aatos");
        etunimet.add("Aatto");
        etunimet.add("Aatu");
        etunimet.add("Ahti");
        etunimet.add("Ahto");
        etunimet.add("Ahvo");
        etunimet.add("Aimo");
        etunimet.add("Aki");
        etunimet.add("Akseli");
        etunimet.add("Aku");
        etunimet.add("Albert");
        etunimet.add("Ale");
        etunimet.add("Aleksanteri");
        etunimet.add("Aleksi");
        etunimet.add("Aleksis");
        etunimet.add("Alfred");
        etunimet.add("Ali");
        etunimet.add("Allan");
        etunimet.add("Alpi");
        etunimet.add("Alpo");
        etunimet.add("Altti");
        etunimet.add("Alvar");
        etunimet.add("Alvi");
        etunimet.add("Ano");
        etunimet.add("Anselmi");
        etunimet.add("Anssi");
        etunimet.add("Antero");
        etunimet.add("Anton");
        etunimet.add("Antti");
        etunimet.add("Antto");
        etunimet.add("Anttoni");
        etunimet.add("Arhippa");
        etunimet.add("Arho");
        etunimet.add("Ari");
        etunimet.add("Armas");
        etunimet.add("Arsi");
        etunimet.add("Arto");
        etunimet.add("Arttu");
        etunimet.add("Artturi");
        etunimet.add("Arvi");
        etunimet.add("Arvo");
        etunimet.add("Asko");
        etunimet.add("Aslak");
        etunimet.add("Asmo");
        etunimet.add("Asser");
        etunimet.add("Atro");
        etunimet.add("Atso");
        etunimet.add("Atte");
        etunimet.add("August");
        etunimet.add("Aukusti");
        etunimet.add("Aulis");
        etunimet.add("Auno");
        etunimet.add("Auvo");
        etunimet.add("Benjamin");
        etunimet.add("Daavid");
        etunimet.add("Daniel");
        etunimet.add("Edvard");
        etunimet.add("Eeli");
        etunimet.add("Eelis");
        etunimet.add("Eemeli");
        etunimet.add("Eemil");
        etunimet.add("Eerik");
        etunimet.add("Eerikki");
        etunimet.add("Eero");
        etunimet.add("Eetu");
        etunimet.add("Eevert");
        etunimet.add("Einari");
        etunimet.add("Eino");
        etunimet.add("Elias");
        etunimet.add("Eljas");
        etunimet.add("Elmer");
        etunimet.add("Elmeri");
        etunimet.add("Elmo");
        etunimet.add("Ensio");
        etunimet.add("Erkka");
        etunimet.add("Erkki");
        etunimet.add("Ernesti");
        etunimet.add("Erno");
        etunimet.add("Esa");
        etunimet.add("Esaias");
        etunimet.add("Esko");
        etunimet.add("Frans");
        etunimet.add("Gabriel");
        etunimet.add("Hannes");
        etunimet.add("Hannu");
        etunimet.add("Hans");
        etunimet.add("Harri");
        etunimet.add("Heikki");
        etunimet.add("Heimo");
        etunimet.add("Heino");
        etunimet.add("Hemminki");
        etunimet.add("Hemmo");
        etunimet.add("Henri");
        etunimet.add("Henrik");
        etunimet.add("Henrikki");
        etunimet.add("Herkko");
        etunimet.add("Herman");
        etunimet.add("Hermanni");
        etunimet.add("Iikka");
        etunimet.add("Iiro");
        etunimet.add("Iisakki");
        etunimet.add("Iivari");
        etunimet.add("Iivo");
        etunimet.add("Ilari");
        etunimet.add("Ilkka");
        etunimet.add("Ilmari");
        etunimet.add("Ilmo");
        etunimet.add("Ilpo");
        etunimet.add("Ilppo");
        etunimet.add("Immanuel");
        etunimet.add("Immo");
        etunimet.add("Into");
        etunimet.add("Isko");
        etunimet.add("Ismo");
        etunimet.add("Isto");
        etunimet.add("Jaakkima");
        etunimet.add("Jaakko");
        etunimet.add("Jaakob");
        etunimet.add("Jaakoppi");
        etunimet.add("Jalmari");
        etunimet.add("Jalo");
        etunimet.add("Jami");
        etunimet.add("Jani");
        etunimet.add("Janne");
        etunimet.add("Jari");
        etunimet.add("Jarkko");
        etunimet.add("Jarmo");
        etunimet.add("Jarno");
        etunimet.add("Jasper");
        etunimet.add("Jere");
        etunimet.add("Jeremias");
        etunimet.add("Jesper");
        etunimet.add("Jesse");
        etunimet.add("Jimi");
        etunimet.add("Jiri");
        etunimet.add("Joakim");
        etunimet.add("Joel");
        etunimet.add("Johannes");
        etunimet.add("Joni");
        etunimet.add("Jonne");
        etunimet.add("Jonni");
        etunimet.add("Joona");
        etunimet.add("Joonas");
        etunimet.add("Joonatan");
        etunimet.add("Joosef");
        etunimet.add("Jooseppi");
        etunimet.add("Jori");
        etunimet.add("Jorma");
        etunimet.add("Jouko");
        etunimet.add("Jouni");
        etunimet.add("Jousia");
        etunimet.add("Juha");
        etunimet.add("Juhana");
        etunimet.add("Juhani");
        etunimet.add("Juho");
        etunimet.add("Jukka");
        etunimet.add("Julius");
        etunimet.add("Jussi");
        etunimet.add("Justus");
        etunimet.add("Juuso");
        etunimet.add("Jyri");
        etunimet.add("Jyrki");
        etunimet.add("Kaapo");
        etunimet.add("Kaappo");
        etunimet.add("Kaapro");
        etunimet.add("Kaarle");
        etunimet.add("Kaarlo");
        etunimet.add("Kai");
        etunimet.add("Kalervo");
        etunimet.add("Kaleva");
        etunimet.add("Kalevi");
        etunimet.add("Kalle");
        etunimet.add("Kari");
        etunimet.add("Karri");
        etunimet.add("Kasperi");
        etunimet.add("Kauko");
        etunimet.add("Kauno");
        etunimet.add("Keijo");
        etunimet.add("Keimo");
        etunimet.add("Kerkko");
        etunimet.add("Kim");
        etunimet.add("Kimmo");
        etunimet.add("Klaus");
        etunimet.add("Konsta");
        etunimet.add("Konstantin");
        etunimet.add("Kosti");
        etunimet.add("Kristian");
        etunimet.add("Kuisma");
        etunimet.add("Kullervo");
        etunimet.add("Kustaa");
        etunimet.add("Kustavi");
        etunimet.add("Kyösti");
        etunimet.add("Lari");
        etunimet.add("Lasse");
        etunimet.add("Lassi");
        etunimet.add("Launo");
        etunimet.add("Lauri");
        etunimet.add("Leevi");
        etunimet.add("Lenni");
        etunimet.add("Leo");
        etunimet.add("Luukas");
        etunimet.add("Lyly");
        etunimet.add("Mainio");
        etunimet.add("Manne");
        etunimet.add("Manu");
        etunimet.add("Markku");
        etunimet.add("Marko");
        etunimet.add("Markus");
        etunimet.add("Martti");
        etunimet.add("Matias");
        etunimet.add("Matti");
        etunimet.add("Mauno");
        etunimet.add("Maunu");
        etunimet.add("Mauri");
        etunimet.add("Max");
        etunimet.add("Mies");
        etunimet.add("Miika");
        etunimet.add("Miikka");
        etunimet.add("Mika");
        etunimet.add("Mikael");
        etunimet.add("Mikko");
        etunimet.add("Miko");
        etunimet.add("Miro");
        etunimet.add("Miska");
        etunimet.add("Nestori");
        etunimet.add("Niilo");
        etunimet.add("Niki");
        etunimet.add("Niklas");
        etunimet.add("Niko");
        etunimet.add("Nikodemus");
        etunimet.add("Nikolai");
        etunimet.add("Nuutti");
        etunimet.add("Nyyrikki");
        etunimet.add("Ohto");
        etunimet.add("Oiva");
        etunimet.add("Olavi");
        etunimet.add("Oliver");
        etunimet.add("Olli");
        etunimet.add("Onni");
        etunimet.add("Orvo");
        etunimet.add("Oskari");
        etunimet.add("Osmo");
        etunimet.add("Ossi");
        etunimet.add("Ossian");
        etunimet.add("Otso");
        etunimet.add("Otto");
        etunimet.add("Paavali");
        etunimet.add("Paavo");
        etunimet.add("Päiviö");
        etunimet.add("Päivö");
        etunimet.add("Panu");
        etunimet.add("Pasi");
        etunimet.add("Patrik");
        etunimet.add("Paul");
        etunimet.add("Pauli");
        etunimet.add("Pekka");
        etunimet.add("Pekko");
        etunimet.add("Pellervo");
        etunimet.add("Pentti");
        etunimet.add("Pertti");
        etunimet.add("Perttu");
        etunimet.add("Petri");
        etunimet.add("Petteri");
        etunimet.add("Pietari");
        etunimet.add("Pirkka");
        etunimet.add("Pyry");
        etunimet.add("Raafael");
        etunimet.add("Raimo");
        etunimet.add("Raine");
        etunimet.add("Rainer");
        etunimet.add("Raino");
        etunimet.add("Rami");
        etunimet.add("Rasmus");
        etunimet.add("Rauli");
        etunimet.add("Rauno");
        etunimet.add("Reijo");
        etunimet.add("Reima");
        etunimet.add("Reino");
        etunimet.add("Reko");
        etunimet.add("Rikhard");
        etunimet.add("Riku");
        etunimet.add("Risto");
        etunimet.add("Robert");
        etunimet.add("Roni");
        etunimet.add("Roope");
        etunimet.add("Sakari");
        etunimet.add("Saku");
        etunimet.add("Salomo");
        etunimet.add("Salomon");
        etunimet.add("Sami");
        etunimet.add("Sampo");
        etunimet.add("Sampsa");
        etunimet.add("Samu");
        etunimet.add("Samuel");
        etunimet.add("Samuli");
        etunimet.add("Santeri");
        etunimet.add("Santtu");
        etunimet.add("Saul");
        etunimet.add("Sauli");
        etunimet.add("Sebastian");
        etunimet.add("Seppo");
        etunimet.add("Severi");
        etunimet.add("Silvo");
        etunimet.add("Simo");
        etunimet.add("Sipi");
        etunimet.add("Sippo");
        etunimet.add("Soini");
        etunimet.add("Sulevi");
        etunimet.add("Sulho");
        etunimet.add("Sulo");
        etunimet.add("Sylvester");
        etunimet.add("Taavetti");
        etunimet.add("Taavi");
        etunimet.add("Tahvo");
        etunimet.add("Taisto");
        etunimet.add("Taito");
        etunimet.add("Taneli");
        etunimet.add("Tapani");
        etunimet.add("Tapio");
        etunimet.add("Tarmo");
        etunimet.add("Tarvo");
        etunimet.add("Tatu");
        etunimet.add("Tauno");
        etunimet.add("Teemu");
        etunimet.add("Teijo");
        etunimet.add("Tenho");
        etunimet.add("Teppo");
        etunimet.add("Terho");
        etunimet.add("Tero");
        etunimet.add("Teuvo");
        etunimet.add("Timi");
        etunimet.add("Timo");
        etunimet.add("Tino");
        etunimet.add("Toimi");
        etunimet.add("Toivo");
        etunimet.add("Tomi");
        etunimet.add("Tommi");
        etunimet.add("Toni");
        etunimet.add("Topi");
        etunimet.add("Topias");
        etunimet.add("Torsti");
        etunimet.add("Touko");
        etunimet.add("Tuomas");
        etunimet.add("Tuomo");
        etunimet.add("Turkka");
        etunimet.add("Turo");
        etunimet.add("Tuukka");
        etunimet.add("Tuure");
        etunimet.add("Ukko");
        etunimet.add("Uljas");
        etunimet.add("Untamo");
        etunimet.add("Unto");
        etunimet.add("Uolevi");
        etunimet.add("Uoti");
        etunimet.add("Urho");
        etunimet.add("Urmas");
        etunimet.add("Urpo");
        etunimet.add("Usko");
        etunimet.add("Uuno");
        etunimet.add("Väinämö");
        etunimet.add("Väinö");
        etunimet.add("Valdemar");
        etunimet.add("Valentin");
        etunimet.add("Valio");
        etunimet.add("Valo");
        etunimet.add("Valto");
        etunimet.add("Valtteri");
        etunimet.add("Veeti");
        etunimet.add("Veijo");
        etunimet.add("Veikka");
        etunimet.add("Veikko");
        etunimet.add("Veini");
        etunimet.add("Veli");
        etunimet.add("Verneri");
        etunimet.add("Vertti");
        etunimet.add("Vesa");
        etunimet.add("Vihtori");
        etunimet.add("Vilhelm");
        etunimet.add("Vilho");
        etunimet.add("Vili");
        etunimet.add("Viljami");
        etunimet.add("Viljo");
        etunimet.add("Ville");
        etunimet.add("Vilppu");
        etunimet.add("Visa");
        etunimet.add("Voitto");
        etunimet.add("Ylermi");
        etunimet.add("Yrjänä");
        etunimet.add("Yrjö");
    }
}