# language: hu
Jellemző: Felhasználói fiók kezelése

  Forgatókönyv: Új felhasználói fiók felvétele
    Amennyiben új felhasználói fiók felvételét kezdeményezem
    Majd megadok egy megfelelő email címet
    És megadok egy megfelelő és egyedi felhasználónevet
    Akkor a rendszer a megadott email címre elküld egy ideiglenes, generált jelszót
    És jelzi a felhasználói fiók sikeres felvételét

  Forgatókönyv: Új felhasználói fiók sikertelen felvétele
    Amennyiben új felhasználói fiók felvételét kezdeményezem
    Majd rossz email címet vagy nem megfelelő egyedi felhasználónevet adok meg
    Akkor a rendszer nem engedi sikeresen lezárni az új felhasználói fiók felvételét

  Forgatókönyv: Sikeres bejelentkezés ideiglenes jelszóval
    Amennyiben megkaptam az ideiglenes jelszavamat az email címemre
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználónevemet és az ideiglenes jelszavamat
    Akkor azonnal elindul a kötelező jelszócsere folyamata
    És végrehajtok egy sikeres jelszócserét
    Akkor sikeres lesz a bejelentkezés

  Forgatókönyv: Sikeres bejelentkezés állandó jelszóval
    Amennyiben rendelkezem érvényes regisztrációval
    És az állandó jelszavam még érvényben van
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználónevemet és az állandó jelszavamat
    Akkor sikeres lesz a bejelentkezés

  Forgatókönyv: Sikertelen bejelentkezés
    Amennyiben rendelkezem érvényes regisztrációval
    Majd kezdeményezem a bejelentkezést
    És rosszul adom meg a felhasználónevemet és/vagy a jelszavamat
    Akkor a rendszer jelzi a sikertelen bejelentkezést és a hiba okát
    És nem lesz sikeres a bejelentkezés

  Forgatókönyv: Sikeres jelszócsere
    Amennyiben elindult a jelszócsere, amit vagy magam kezdeményeztem, vagy a rendszer kötelezően elindította
    És megadom mégegyszer a lecserélendő jelszavamat
    És megadom kétszer ugyanazt az új állandó jelszót, amely megfelel az előírt szabályoknak
    Akkor a rendszer jelzi a jelszócsere sikerességét
    És a jelszavam lejárati ideje 3 hónap múlvára állítódik
    És sikeres lesz a bejelentkezés

  Forgatókönyv: Sikertelen jelszócsere
    Amennyiben elindult a jelszócsere, amit vagy magam kezdeményeztem, vagy a rendszer kötelezően elindította
    És valamilyen adatot nem megfelelően adtam meg
    Akkor a rendszer jelzi a sikertelen jelszócserét és a hiba okát
    És nem lesz sikeres a bejelentkezés

  Forgatókönyv: Elfelejtett jelszó
    Amennyiben rendelkezem érvényes regisztrációval
    Majd jelzem a rendszernek, hogy elfelejtettem a jelszavamat
    És megadom a felhasználónevemet
    Akkor a rendszer jelzi az új ideiglenes jelszó kiküldését és a további tudnivalókat
    És a megadott email címemre elküld egy ideiglenes, generált jelszót

  Forgatókönyv: Lejárt jelszó
    Amennyiben rendelkezem érvényes regisztrációval
    De az állandó jelszavam lejárt
    Majd kezdeményezem a bejelentkezést
    És megadom a felhasználónevemet és az állandó jelszavamat
    Akkor a rendszer jelzi a jelszavam lejáratát és hogy egy új ideiglenes jelszót küld ki
    És a megadott email címemre elküld egy ideiglenes, generált jelszót
    És nem lesz sikeres a bejelentkezés


