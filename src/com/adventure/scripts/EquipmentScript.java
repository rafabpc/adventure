package com.adventure.scripts;

import com.adventure.entity.Equipment;
import com.adventure.sessao.AdventureSession;
import com.adventure.type.EquipmentType;
import com.adventure.type.LootType;
import com.adventure.utils.AdventureColor;

public class EquipmentScript implements AdventureScript{

  @Override
  public void populateGameObjects() {
	  populateHelmets();
	  populateBrestplates();
	  populatePaints();
	  populateBoots();
	  populateWeapons();
	  populateShields();
  }

  private void populateHelmets() {
	  Equipment cb = new Equipment();
	    cb.setName("Copper Helmet");
	    cb.setAttack(0);
	    cb.setDefense(1);
	    cb.setBuyPrice(50);
	    cb.setSellPrice(10);
	    cb.setTipo(EquipmentType.HELMET);
	    cb.setColor(AdventureColor.COPPER);
	    cb.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(cb);
	    
	    Equipment cp = new Equipment();
	    cp.setName("Silver Helmet");
	    cp.setAttack(0);
	    cp.setDefense(5);
	    cp.setBuyPrice(300);
	    cp.setSellPrice(70);
	    cp.setTipo(EquipmentType.HELMET);
	    cp.setColor(AdventureColor.SILVER);
	    cp.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(cp);
	    
	    Equipment co = new Equipment();
	    co.setName("Gold Helmet");
	    co.setAttack(1);
	    co.setDefense(10);
	    co.setBuyPrice(800);
	    co.setSellPrice(200);
	    co.setTipo(EquipmentType.HELMET);
	    co.setColor(AdventureColor.GOLD);
	    co.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(co);
	    
	    Equipment cpl = new Equipment();
	    cpl.setName("Platinum Helmet");
	    cpl.setAttack(2);
	    cpl.setDefense(20);
	    cpl.setBuyPrice(3000);
	    cpl.setSellPrice(400);
	    cpl.setTipo(EquipmentType.HELMET);
	    cpl.setColor(AdventureColor.PLATINUM);
	    cpl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(cpl);
	    
	    Equipment cd = new Equipment();
	    cd.setName("Diamond Helmet");
	    cd.setAttack(5);
	    cd.setDefense(50);
	    cd.setBuyPrice(25000);
	    cd.setSellPrice(2000);
	    cd.setTipo(EquipmentType.HELMET);
	    cd.setColor(AdventureColor.DIAMOND);
	    cd.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(cd);
	    
	    Equipment cl = new Equipment();
	    cl.setName("Legendary Helmet");
	    cl.setAttack(10);
	    cl.setDefense(100);
	    cl.setBuyPrice(100000);
	    cl.setSellPrice(5000);
	    cl.setTipo(EquipmentType.HELMET);
	    cl.setColor(AdventureColor.LEGENDARY);
	    cl.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(cl);
  }
  
  private void populateBrestplates() {
	  Equipment peib = new Equipment();
	    peib.setName("Copper Breastplate");
	    peib.setAttack(0);
	    peib.setDefense(1);
	    peib.setBuyPrice(50);
	    peib.setSellPrice(10);
	    peib.setTipo(EquipmentType.BREASTPLATE);
	    peib.setColor(AdventureColor.COPPER);
	    peib.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(peib);
	    
	    Equipment peip = new Equipment();
	    peip.setName("Silver Breastplate");
	    peip.setAttack(0);
	    peip.setDefense(5);
	    peip.setBuyPrice(300);
	    peip.setSellPrice(70);
	    peip.setTipo(EquipmentType.BREASTPLATE);
	    peip.setColor(AdventureColor.SILVER);
	    peip.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(peip);
	    
	    Equipment peio = new Equipment();
	    peio.setName("Gold Breastplate");
	    peio.setAttack(1);
	    peio.setDefense(10);
	    peio.setBuyPrice(800);
	    peio.setSellPrice(200);
	    peio.setTipo(EquipmentType.BREASTPLATE);
	    peio.setColor(AdventureColor.GOLD);
	    peio.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(peio);
	    
	    Equipment peipl = new Equipment();
	    peipl.setName("Platinum Breastplate");
	    peipl.setAttack(2);
	    peipl.setDefense(20);
	    peipl.setBuyPrice(3000);
	    peipl.setSellPrice(400);
	    peipl.setTipo(EquipmentType.BREASTPLATE);
	    peipl.setColor(AdventureColor.PLATINUM);
	    peipl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(peipl);
	    
	    Equipment peid = new Equipment();
	    peid.setName("Diamond Breastplate");
	    peid.setAttack(5);
	    peid.setDefense(50);
	    peid.setBuyPrice(25000);
	    peid.setSellPrice(2000);
	    peid.setTipo(EquipmentType.BREASTPLATE);
	    peid.setColor(AdventureColor.DIAMOND);
	    peid.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(peid);
	    
	    Equipment peil = new Equipment();
	    peil.setName("Legendary Breastplate");
	    peil.setAttack(10);
	    peil.setDefense(100);
	    peil.setBuyPrice(100000);
	    peil.setSellPrice(5000);
	    peil.setTipo(EquipmentType.BREASTPLATE);
	    peil.setColor(AdventureColor.LEGENDARY);
	    peil.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(peil);
  }
  
  private void populatePaints() {
	  Equipment perb = new Equipment();
	    perb.setName("Copper Paints");
	    perb.setAttack(0);
	    perb.setDefense(1);
	    perb.setBuyPrice(50);
	    perb.setSellPrice(10);
	    perb.setTipo(EquipmentType.PAINTS);
	    perb.setColor(AdventureColor.COPPER);
	    perb.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(perb);
	    
	    Equipment perp = new Equipment();
	    perp.setName("Silver Paints");
	    perp.setAttack(0);
	    perp.setDefense(5);
	    perp.setBuyPrice(300);
	    perp.setSellPrice(70);
	    perp.setTipo(EquipmentType.PAINTS);
	    perp.setColor(AdventureColor.SILVER);
	    perp.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(perp);
	    
	    Equipment pero = new Equipment();
	    pero.setName("Gold Paints");
	    pero.setAttack(1);
	    pero.setDefense(10);
	    pero.setBuyPrice(800);
	    pero.setSellPrice(200);
	    pero.setTipo(EquipmentType.PAINTS);
	    pero.setColor(AdventureColor.GOLD);
	    pero.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(pero);
	    
	    Equipment perpl = new Equipment();
	    perpl.setName("Platinum Paints");
	    perpl.setAttack(2);
	    perpl.setDefense(20);
	    perpl.setBuyPrice(3000);
	    perpl.setSellPrice(400);
	    perpl.setTipo(EquipmentType.PAINTS);
	    perpl.setColor(AdventureColor.PLATINUM);
	    perpl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(perpl);
	    
	    Equipment perd = new Equipment();
	    perd.setName("Diamond Paints");
	    perd.setAttack(5);
	    perd.setDefense(50);
	    perd.setBuyPrice(25000);
	    perd.setSellPrice(2000);
	    perd.setTipo(EquipmentType.PAINTS);
	    perd.setColor(AdventureColor.DIAMOND);
	    perd.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(perd);
	    
	    Equipment perl = new Equipment();
	    perl.setName("Legendary Paints");
	    perl.setAttack(10);
	    perl.setDefense(100);
	    perl.setBuyPrice(100000);
	    perl.setSellPrice(5000);
	    perl.setTipo(EquipmentType.PAINTS);
	    perl.setColor(AdventureColor.LEGENDARY);
	    perl.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(perl);
  }
  
  private void populateBoots() {
	  Equipment peb = new Equipment();
	    peb.setName("Copper Boots");
	    peb.setAttack(0);
	    peb.setDefense(1);
	    peb.setBuyPrice(50);
	    peb.setSellPrice(10);
	    peb.setTipo(EquipmentType.BOOTS);
	    peb.setColor(AdventureColor.COPPER);
	    peb.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(peb);
	    
	    Equipment pep = new Equipment();
	    pep.setName("Silver Boots");
	    pep.setAttack(0);
	    pep.setDefense(5);
	    pep.setBuyPrice(300);
	    pep.setSellPrice(70);
	    pep.setTipo(EquipmentType.BOOTS);
	    pep.setColor(AdventureColor.SILVER);
	    pep.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(pep);
	    
	    Equipment peo = new Equipment();
	    peo.setName("Gold Boots");
	    peo.setAttack(1);
	    peo.setDefense(10);
	    peo.setBuyPrice(800);
	    peo.setSellPrice(200);
	    peo.setTipo(EquipmentType.BOOTS);
	    peo.setColor(AdventureColor.GOLD);
	    peo.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(peo);
	    
	    Equipment pepl = new Equipment();
	    pepl.setName("Platinum Boots");
	    pepl.setAttack(2);
	    pepl.setDefense(20);
	    pepl.setBuyPrice(3000);
	    pepl.setSellPrice(400);
	    pepl.setTipo(EquipmentType.BOOTS);
	    pepl.setColor(AdventureColor.PLATINUM);
	    pepl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(pepl);
	    
	    Equipment ped = new Equipment();
	    ped.setName("Diamond Boots");
	    ped.setAttack(5);
	    ped.setDefense(50);
	    ped.setBuyPrice(25000);
	    ped.setSellPrice(2000);
	    ped.setTipo(EquipmentType.BOOTS);
	    ped.setColor(AdventureColor.DIAMOND);
	    ped.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(ped);
	    
	    Equipment pel = new Equipment();
	    pel.setName("Legendary Boots");
	    pel.setAttack(10);
	    pel.setDefense(100);
	    pel.setBuyPrice(100000);
	    pel.setSellPrice(5000);
	    pel.setTipo(EquipmentType.BOOTS);
	    pel.setColor(AdventureColor.LEGENDARY);
	    pel.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(pel);
  }
  
  private void populateWeapons() {
	  Equipment ab = new Equipment();
	    ab.setName("Copper Weapon");
	    ab.setAttack(1);
	    ab.setDefense(0);
	    ab.setBuyPrice(50);
	    ab.setSellPrice(10);
	    ab.setTipo(EquipmentType.WEAPON);
	    ab.setColor(AdventureColor.COPPER);
	    ab.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(ab);
	    
	    Equipment ap = new Equipment();
	    ap.setName("Silver Weapon");
	    ap.setAttack(5);
	    ap.setDefense(0);
	    ap.setBuyPrice(300);
	    ap.setSellPrice(70);
	    ap.setTipo(EquipmentType.WEAPON);
	    ap.setColor(AdventureColor.SILVER);
	    ap.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(ap);
	    
	    Equipment ao = new Equipment();
	    ao.setName("Gold Weapon");
	    ao.setAttack(10);
	    ao.setDefense(1);
	    ao.setBuyPrice(800);
	    ao.setSellPrice(200);
	    ao.setTipo(EquipmentType.WEAPON);
	    ao.setColor(AdventureColor.GOLD);
	    ao.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(ao);
	    
	    Equipment apl = new Equipment();
	    apl.setName("Platinum Weapon");
	    apl.setAttack(20);
	    apl.setDefense(2);
	    apl.setBuyPrice(3000);
	    apl.setSellPrice(400);
	    apl.setTipo(EquipmentType.WEAPON);
	    apl.setColor(AdventureColor.PLATINUM);
	    apl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(apl);
	    
	    Equipment ad = new Equipment();
	    ad.setName("Diamond Weapon");
	    ad.setAttack(50);
	    ad.setDefense(5);
	    ad.setBuyPrice(25000);
	    ad.setSellPrice(2000);
	    ad.setTipo(EquipmentType.WEAPON);
	    ad.setColor(AdventureColor.DIAMOND);
	    ad.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(ad);
	    
	    Equipment al = new Equipment();
	    al.setName("Legendary Weapon");
	    al.setAttack(100);
	    al.setDefense(10);
	    al.setBuyPrice(100000);
	    al.setSellPrice(5000);
	    al.setTipo(EquipmentType.WEAPON);
	    al.setColor(AdventureColor.LEGENDARY);
	    al.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(al);
  }
  
  private void populateShields() {
	  Equipment eb = new Equipment();
	    eb.setName("Copper Shield");
	    eb.setAttack(0);
	    eb.setDefense(1);
	    eb.setBuyPrice(50);
	    eb.setSellPrice(10);
	    eb.setTipo(EquipmentType.SHIELD);
	    eb.setColor(AdventureColor.COPPER);
	    eb.setLootType(LootType.COPPER);
	    AdventureSession.addLoot(eb);
	    
	    Equipment ep = new Equipment();
	    ep.setName("Silver Shield");
	    ep.setAttack(0);
	    ep.setDefense(5);
	    ep.setBuyPrice(300);
	    ep.setSellPrice(70);
	    ep.setTipo(EquipmentType.SHIELD);
	    ep.setColor(AdventureColor.SILVER);
	    ep.setLootType(LootType.SILVER);
	    AdventureSession.addLoot(ep);
	    
	    Equipment eo = new Equipment();
	    eo.setName("Gold Shield");
	    eo.setAttack(1);
	    eo.setDefense(10);
	    eo.setBuyPrice(800);
	    eo.setSellPrice(200);
	    eo.setTipo(EquipmentType.SHIELD);
	    eo.setColor(AdventureColor.GOLD);
	    eo.setLootType(LootType.GOLD);
	    AdventureSession.addLoot(eo);
	    
	    Equipment epl = new Equipment();
	    epl.setName("Platinum Shield");
	    epl.setAttack(2);
	    epl.setDefense(20);
	    epl.setBuyPrice(3000);
	    epl.setSellPrice(400);
	    epl.setTipo(EquipmentType.SHIELD);
	    epl.setColor(AdventureColor.PLATINUM);
	    epl.setLootType(LootType.PLATINUM);
	    AdventureSession.addLoot(epl);
	    
	    Equipment ed = new Equipment();
	    ed.setName("Diamond Shield");
	    ed.setAttack(5);
	    ed.setDefense(50);
	    ed.setBuyPrice(25000);
	    ed.setSellPrice(2000);
	    ed.setTipo(EquipmentType.SHIELD);
	    ed.setColor(AdventureColor.DIAMOND);
	    ed.setLootType(LootType.DIAMOND);
	    AdventureSession.addLoot(ed);
	    
	    Equipment el = new Equipment();
	    el.setName("Legendary Shield");
	    el.setAttack(10);
	    el.setDefense(100);
	    el.setBuyPrice(100000);
	    el.setSellPrice(5000);
	    el.setTipo(EquipmentType.SHIELD);
	    el.setColor(AdventureColor.LEGENDARY);
	    el.setLootType(LootType.LEGENDARY);
	    AdventureSession.addLoot(el);
  }
  
}
