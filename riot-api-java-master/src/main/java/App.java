import java.util.Date;
import java.util.Scanner;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates using the RiotApi to request summoner information for a given summoner name
 */
public class App {

    public static void main(String[] args) throws RiotApiException {
        ApiConfig config = new ApiConfig().setKey("RGAPI-4550fe28-c228-40d0-a062-3061f27c7137");
        RiotApi api = new RiotApi(config);
        System.out.println("Podaj serwer (EUW, EUNE):");
        
        Scanner scanner = new Scanner(System.in);
        String serwer = scanner.nextLine().toLowerCase();
        Platform serwe;
        switch(serwer) {
        case "euw": serwe=Platform.EUW;
        	break;
        case "eune": serwe=Platform.EUNE;
        	break;
        default: System.out.println("Podałeś zły serwer!!!");
        	return ;
        
        }
        System.out.println("Podaj nick:");
        String nick = scanner.nextLine();
        // id jest dane z tej strony https://darkintaqt.com/blog/champ-ids
        System.out.println("Podaj id championa:");
        Integer id = scanner.nextInt();
        
        
        Summoner summoner = api.getSummonerByName(serwe, nick);
        ChampionMastery champion = api.getChampionMasteriesBySummonerByChampion(serwe, summoner.getId(), id);
        if(champion.isChestGranted()) {
        	System.out.println("Nie masz dostąpnej skrzynki na tym championie.");
        }else {
        	System.out.println("Masz dostępną skrzynke na tym championie.");
        }
        System.out.println("Twój lvl maestri to "+champion.getChampionLevel()+" jest to "+ String.valueOf(champion.getChampionPoints()) +" punktów maestri.");
        
    }
}