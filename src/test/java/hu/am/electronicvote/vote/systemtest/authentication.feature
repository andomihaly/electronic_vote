# language: hu
Jellemző: Állampolgár azonosítása


  Forgatókönyv: Sikeres azonosítása jelszóval
    Amennyiben megadom a helyes felhasználónév-jelszó párosom
    Akkor be vagyok jelentkezve a rendszerbe
    
  Forgatókönyv: Sikeres azonosítás eSzemélyivel
    Amennyiben kártyaolvasóval beolvasom az eSzemélyim
    És megadom a helyes PIN kódomat
    Akkor be vagyok jelentkezve a rendszerbe
    
  Forgatókönyv: Sikertelen azonosítás jelszóval
    Amennyiben nem helyes felhasználónév-jelszó párost adok meg
    Akkor nem vagyok bejelentkezve a rendszerbe
    És értesítést kapok a sikertelen bejelentkezésről
    
  Forgatókönyv: Sikertelen azonosítás eSzemélyivel
    Amennyiben nem sikerül azonosítanom magam eSzemélyivel
    Akkor nem vagyok bejelentkezve a rendszerbe
    És értesítést kapok a sikertelen bejelentkezésről
    
  Forgatókönyv: Felhasználó letiltása rövid időre
    Amennyiben 3-szor helytelen jelszót adok meg a felhasználónevemhez
    Akkor 10 percig nem tudok bejelentkezni a helyes jelszóval sem
    És értesítést kapok erről

  @slow
  Forgatókönyv: Felhasználó bejelentkezés engedélyezése rövid letiltás után
    Amennyiben rövid időre le voltam tiltva
    És letelt a rövid idejű tiltás
    Majd megadom a helyes felhasználónév-jelszó párosom
    Akkor be vagyok jelentkezve a rendszerbe

  @slow
  Forgatókönyv: Felhasználó letiltása hosszú időre
    Amennyiben rövid időre le voltam tiltva
    És 4-szer helytelen jelszót adok meg a felhasználónevemhez
    Akkor 2 óráig nem tudok bejelentkezni a helyes jelszóval sem
    És értesítést kapok erről

  @slow
  Forgatókönyv: Felhasználó bejelentkezés engedélyezése hosszú letiltás után
    Amennyiben hosszú időre le voltam tiltva
    És letelt a hosszú idejű tiltás
    Majd megadom a helyes felhasználónév-jelszó párosom
    Akkor be vagyok jelentkezve a rendszerbe

  @slow
  Forgatókönyv: Felhasználó kitiltása személyes azonosításig
	Amennyiben hosszú időre le voltam tiltva
    És 4-szer helytelen jelszót adok meg a felhasználónevemhez
    Akkor személyes azonosításig nem tudok bejelentkezni a helyes jelszóval sem
    És értesítést kapok erről
    
   
   
    
  
  