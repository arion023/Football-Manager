package com.example.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum ClubLogo {
    CRACOVIA_LOGO("Cracovia Krakow", "images/clubs/cracovia_krakow.png"),
    GORNIK_ZABRZE_LOGO("Gornik Zabrze", "images/clubs/gornik_zabrze.png"),
    GORNIK_LECZNA_LOGO("Gornik Leczna", "images/clubs/gornik_leczna.png"),
    JAGIELLONA_BIALYSTOK_LOGO("Jagiellonia", "images/clubs/jagiellonia_bialystok.png"),
    LECH_POZNAN_LOGO("Lech Poznan", "images/clubs/lech_poznan.png"),
    LECHIA_GDANSK_LOGO("Lechia Gdansk", "images/clubs/lechia_gdansk.png"),
    LEGIA_WARSZAWA_LOGO("Legia Warszawa", "images/clubs/legia_warszawa.png"),
    PIAST_GLIWICE_LOGO("Piast Gliwice", "images/clubs/piast_gliwice.png"),
    POGON_SZCZECIN_LOGO("Pogon Szczecin", "images/clubs/pogon_szczecin.png"),
    RADOMIAK_RADOM_LOGO("Radomiak Radom", "images/clubs/radomiak_radom.png"),
    RAKOW_CZESTOCHOWA_LOGO("Rakow Czestochowa", "images/clubs/rakow_czestochowa.png"),
    SLASK_WROCLAW_LOGO("Slask Wroclaw", "images/clubs/slask_wroclaw.png"),
    STAL_MIELEC_LOGO("Stal Mielec", "images/clubs/stal_mielec.png"),
    TERMALICA_NIECIECZA_LOGO("Nieciecza", "images/clubs/termalica_nieciecza.png"),
    WARTA_POZNAN_LOGO("Warta Poznan", "images/clubs/warta_poznan.png"),
    WISLA_KRAKOW_LOGO("Wisla Krakow", "images/clubs/wisla_krakow.png"),
    WISLA_PLOCK_LOGO("Wisla Plock", "images/clubs/wisla_plock.png"),
    ZAGLEBIE_LUBIN_LOGO("Zaglebie Lubin", "images/clubs/zaglebie_lubin.png"),
    ;
    private final String name;
    private final String logoUrl;

    public static String getClubLogo(String clubName) {
        Optional<ClubLogo> clubLogo = Arrays.stream(ClubLogo.values()).filter(e -> e.getName().equals(clubName)).findFirst();
        return clubLogo.map(ClubLogo::getLogoUrl).orElse("images/user_club_logo.png");
    }
}
