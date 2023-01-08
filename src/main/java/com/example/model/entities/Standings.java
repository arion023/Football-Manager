package com.example.model.entities;

import com.example.model.entities.Club;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class Standings {
    private Map<Integer, Club> standingsMap;//TODO może do usunięcia
}
