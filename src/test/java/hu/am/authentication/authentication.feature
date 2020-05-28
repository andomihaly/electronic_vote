# language: hu
Jellemző: Felhasználó azonosítás

  Forgatókönyv: Új felhasználói fiók felvétele
    Amennyiben új felhasználói fiók felvételét indítom egy megfelelő email cím és egy egyedi felhasználónév megadásával
    Akkor a rendszer a megadott email címre elküld egy új, egyszerhasználatos jelszót

  Forgatókönyv: Új felhasználói fiók sikertelen felvétele hibás email címmel
    Amennyiben új felhasználói fiók felvételét indítom hibás email címmel
    Akkor a rendszer jelzést küld a hibás email címről

  Forgatókönyv: Új felhasználói fiók sikertelen felvétele már létező felhasználónévvel
    Amennyiben új felhasználói fiók felvételét indítom már létező felhasználónévvel
    Akkor a rendszer jelzést küld a foglalt felhasználónévről

  Forgatókönyv: Elfelejtett jelszó kezelése
    Amennyiben jelzem a rendszernek, hogy elfelejtettem a jelszavamat
    És megadom az érvényes felhasználónevemet
    Akkor a rendszer jelzi, hogy elküldi az emailt
    És a megadott email címre elküld egy új, egyszerhasználatos jelszót

  Forgatókönyv: Elfelejtett jelszó kezelése érvénytelen felhasználónévvel
    Amennyiben jelzem a rendszernek, hogy elfelejtettem a jelszavamat
    Akkor a rendszer jelzi, hogy elküldi az emailt
    De nem küld el semmilyen emailt

  Forgatókönyv: Sikeres jelszócsere egyszerhasználatos jelszó esetén
    Amennyiben kezdeményezek egy jelszócserét
    És megadom az egyszerhasználatos jelszavamat
    És megadom kétszer ugyanazt az új jelszót, amely 8 hosszú
    Akkor a rendszer jelzi a jelszócsere sikerességét

  Forgatókönyv: Sikeres jelszócsere
    Amennyiben kezdeményezek egy jelszócserét
    És megadom az érvényes jelszavamat
    És megadom kétszer ugyanazt az új jelszót, amely 8 hosszú
    Akkor a rendszer jelzi a jelszócsere sikerességét

  Forgatókönyv: Sikertelen jelszócsere érvénytelen jelszóval
    Amennyiben kezdeményezek egy jelszócserét
    És érvénytelen aktuális jelszót adok meg
    És megadom kétszer ugyanazt az új jelszót, amely 8 hosszú
    Akkor a rendszer jelzi, hogy nem megfelelő a megadott aktuális jelszavam

  Forgatókönyv: Sikertelen jelszócsere nem szabályos új jelszóval
    Amennyiben kezdeményezek egy jelszócserét
    És megadom az aktuális jelszavamat
    És megadom kétszer ugyanazt az új jelszót, amely 7 hosszú
    Akkor a rendszer jelzi, hogy nem megfelelő új jelszót adtam

  Forgatókönyv: Sikeres azonosítás
    Amennyiben a bejelentkezéshez megadom a felhasználónevemet
    És megadom az érvényes jelszavamat
    Akkor sikeres lesz az azonosítás

  Forgatókönyv: Sikertelen azonosítás érvénytelen jelszóval
    Amennyiben a bejelentkezéshez megadom a felhasználónevemet
    És érvénytelen aktuális jelszót adok meg
    Akkor sikertelen lesz az azonosítás

  Forgatókönyv: Sikertelen azonosítás egyszerhasználatos jelszóval
    Amennyiben a bejelentkezéshez megadom a felhasználónevemet
    És megadom az egyszerhasználatos jelszavamat
    Akkor sikertelen lesz az azonosítás


