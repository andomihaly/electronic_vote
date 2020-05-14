# language: hu
Jellemző: Állampolgárok regisztrációja szavazásokhoz

  Forgatókönyv: Sikeres állampolgári regisztráció meglevő felhasználói fiókkal
    Amennyiben új regisztrációt kezdeményezek egy ügyfélszolgálaton
    És sikeresen azonosítom magam személyimmel vagy más azonosító kártyámmal
    Majd megadom egy működő felhasználói fiókom azonosítási adatait
    És megadok egy működő email címet
    És az ügyfélszolgálatos sikeresen felveszi a születési dátumomat, állandó lakcímemet és nevemet
    Akkor a regisztráció befejezéseként a rendszer kiküld egy értesítő emailt a regisztrációról
    Majd jelzi a regisztráció sikeres lezárását

  Forgatókönyv: Sikeres állampolgári regisztráció új felhasználói fiók felvételével
    Amennyiben új regisztrációt kezdeményezek egy ügyfélszolgálaton
    És sikeresen azonosítom magam személyimmel vagy más azonosító kártyámmal
    Majd felveszünk egy új felhasználói fiókot számomra
    És megadok egy működő email címet
    És az ügyfélszolgálatos sikeresen felveszi a születési dátumomat, állandó lakcímemet és nevemet
    Akkor a regisztráció befejezéseként a rendszer kiküld egy értesítő emailt a regisztrációról
    Majd jelzi a regisztráció sikeres lezárását

  Forgatókönyv: Sikertelen állampolgári regisztráció új felhasználói fiók felvételének sikertelensége miatt
    Amennyiben új regisztrációt kezdeményezek egy ügyfélszolgálaton
    És sikeresen azonosítom magam személyimmel vagy más azonosító kártyámmal
    Majd sikertelenül megpróbálunk felvenni egy új felhasználói fiókot számomra
    Akkor a rendszer nem engedi sikeresen lezárni az állampolgári regisztrációt

  Forgatókönyv: Sikertelen állampolgári regisztráció rossz adatok miatt
    Amennyiben új regisztrációt kezdeményezek egy ügyfélszolgálaton
    És sikeresen azonosítom magam személyimmel vagy más azonosító kártyámmal
    És az ügyfélszolgálatos nem megfelelő születési dátumot vagy lakcímemet vagy nevet vagy email címet ad meg számomra
    Akkor a rendszer nem engedi sikeresen lezárni az állampolgári regisztrációt

  Forgatókönyv: Állampolgári regisztráció törlése
    Amennyiben rendelkeztem korábban érvényes regisztrációval
    Majd központilag törlik a regisztrációmat
    Akkor email-ben kapok értesítést a regisztrációm törléséről


