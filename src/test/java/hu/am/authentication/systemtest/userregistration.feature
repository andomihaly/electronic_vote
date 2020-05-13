# language: hu
Jellemző: Felhasználói regisztráció

  Forgatókönyv: Sikeres regisztráció
    Amennyiben új regisztrációt kezdeményezek
    Majd sikeresen azonosítom magam az ügyfélszolgálaton személyimmel vagy más azonosító kártyámmal
    És megadom egy megfelelő email címemet
    És megadok egy megfelelő és egyedi felhasználói azonosítót magamnak
    Majd az ügyfélszolgálatos befejezi a regisztrációt
    Akkor a rendszer jelzi számunkra a sikeres regisztrációt
    És a megadott email címemre elküld egy ideiglenes, generált jelszót

  Forgatókönyv: Sikertelen regisztráció
    Amennyiben új regisztrációt kezdeményezek
    Majd nem sikerül azonosítanom magam, vagy rossz email címet vagy azonosítót adtam  meg
    Akkor a rendszer jelzi a sikertelen regisztrációt és a hiba okát

  Forgatókönyv: Sikeres bejelentkezés ideiglenes jelszóval
    Amennyiben megkaptam az ideiglenes jelszavamat az email címemre
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználói azonosítómat és az ideiglenes jelszavamat
    Akkor azonnal elindul a kötelező jelszócsere folyamata
    És végrehajtok egy sikeres jelszócserét
    Akkor be leszek jelentkezve

  Forgatókönyv: Sikeres bejelentkezés állandó jelszóval
    Amennyiben rendelkezem érvényes regisztrációval
    És az állandó jelszavam még érvényben van
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználói azonosítómat és az állandó jelszavamat
    Akkor be leszek jelentkezve

  Forgatókönyv: Sikertelen bejelentkezés
    Amennyiben rendelkezem érvényes regisztrációval
    Majd kezdeményezem a bejelentkezést
    És rosszul adom meg a felhasználói azonosítómat és/vagy a jelszavamat
    Akkor a rendszer jelzi a sikertelen bejelentkezést és a hiba okát
    És nem leszek bejelentkezve

  Forgatókönyv: Sikeres jelszócsere
    Amennyiben elindult a jelszócsere, amit vagy magam kezdeményeztem, vagy a rendszer kötelezően elindította
    És megadom mégegyszer a lecserélendő jelszavamat
    És megadom kétszer ugyanazt az új állandó jelszót, amely megfelel az előírt szabályoknak
    Akkor a rendszer jelzi a jelszócsere sikerességét
    És a jelszavam lejárati ideje 3 hónap múlvára állítódik
    És be leszek jelentkezve

  Forgatókönyv: Sikertelen jelszócsere
    Amennyiben elindult a jelszócsere, amit vagy magam kezdeményeztem, vagy a rendszer kötelezően elindította
    És valamilyen adatot nem megfelelően adtam meg
    Akkor a rendszer jelzi a sikertelen jelszócserét és a hiba okát
    És nem leszek bejelentkezve

  Forgatókönyv: Elfelejtett jelszó
    Amennyiben rendelkezem érvényes regisztrációval
    És nem vagyok bejelentkezve
    Majd jelzem a rendszernek, hogy elfelejtettem a jelszavamat
    És megadom a felhasználói azonosítómat
    Akkor a rendszer jelzi az új ideiglenes jelszó kiküldését és a további tudnivalókat
    És a megadott email címemre elküld egy ideiglenes, generált jelszót
    És továbbra sem leszek bejelentkezve

  Forgatókönyv: Lejárt jelszó
    Amennyiben rendelkezem érvényes regisztrációval
    És nem vagyok bejelentkezve
    De az állandó jelszavam lejárt
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználói azonosítómat és az állandó jelszavamat
    Akkor a rendszer jelzi a jelszavam lejáratát és hogy egy új ideiglenes jelszót küld ki
    És a megadott email címemre elküld egy ideiglenes, generált jelszót
    És továbbra sem leszek bejelentkezve

  Forgatókönyv: Regisztráció törlése
    Amennyiben rendelkeztem korábban érvényes regisztrációval
    De nem jelentkeztem be sikeresen 1 év óta, vagy egyéb okból törölték központilag a regisztrációmat
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználói azonosítómat és az állandó jelszavamat
    Akkor a rendszer jelzi, hogy nincs érvényes regisztrációm
    És továbbra sem leszek bejelentkezve


