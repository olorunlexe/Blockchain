import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Emmanuel.Agboola on 8/7/2019.
 */
public class NoobChain {
    //    public static void main(String[] args) {
//        Block genesisBlock = new Block("Hi im the first block", "0");
//        System.out.println("Hash for block 1 : " + genesisBlock.hash);
//
//        Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
//        System.out.println("Hash for block 2 : " + secondBlock.hash);
//
//        Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
//        System.out.println("Hash for block 3 : " + thirdBlock.hash);
//    }
//////////////////////////////////////////////////////////////======================//////////////////////////////////////////
//    public static ArrayList<Block> blockchain = new ArrayList<Block>();
//
//    public static void main(String[] args) {
//        //add our blocks to the blockchain ArrayList:
//        blockchain.add(new Block("Hi im the first block", "0"));
//        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
//        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
//
//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println(blockchainJson);
//        System.out.println("Check to Ascertain the BlockChain is Valid: "+isChainValid());
//
//    }
//
//    public static Boolean isChainValid() {
//        Block currentBlock;
//        Block previousBlock;
//
//        //loop through blockchain to check hashes:
//        for(int i=1; i < blockchain.size(); i++) {
//            currentBlock = blockchain.get(i);
//            previousBlock = blockchain.get(i-1);
//            //compare registered hash and calculated hash:
//            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
//                System.out.println("Current Hashes not equal");
//                return false;
//            }
//            //compare previous hash and registered previous hash
//            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
//                System.out.println("Previous Hashes not equal");
//                return false;
//            }
//        }
//        return true;
//    }
    /////////////////////////////////////==========================///////////////////////////////////////////////
//    public static ArrayList<Block> blockchain = new ArrayList<Block>();
//    public static int difficulty = 3;
//
//    public static void main(String[] args) {
//        //add our blocks to the blockchain ArrayList:
//
//        blockchain.add(new Block("Hi im the first block", "0"));
//        System.out.println("Trying to Mine block 1... ");
//        blockchain.get(0).mineBlock(difficulty);
//
//        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
//        System.out.println("Trying to Mine block 2... ");
//        blockchain.get(1).mineBlock(difficulty);
//
//        blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));
//        System.out.println("Trying to Mine block 3... ");
//        blockchain.get(2).mineBlock(difficulty);
//
//        System.out.println("\nBlockchain is Valid: " + isChainValid());
//
//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println("\nThe block chain: ");
//        System.out.println(blockchainJson);
//    }
//
//    public static Boolean isChainValid() {
//        Block currentBlock;
//        Block previousBlock;
//        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
//
//        //loop through blockchain to check hashes:
//        for (int i = 1; i < blockchain.size(); i++) {
//            currentBlock = blockchain.get(i);
//            previousBlock = blockchain.get(i - 1);
//            //compare registered hash and calculated hash:
//            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
//                System.out.println("Current Hashes not equal");
//                return false;
//            }
//            //compare previous hash and registered previous hash
//            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
//                System.out.println("Previous Hashes not equal");
//                return false;
//            }
//            //check if hash is solved
//            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
//                System.out.println("This block hasn't been mined");
//                return false;
//            }
//        }
//        return true;
//    }
    //////////////////**********************************Another Block*******************************/////////////////////
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>(); //list of all unspent transactions.
    public static int difficulty = 5;
    public static Wallet walletA;
    public static Wallet walletB;
    public static float minimumTransaction;

    public static void main(String[] args) {
        //Setup Bouncey castle as a Security Provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //Create the new wallets
        walletA = new Wallet();
        walletB = new Wallet();
        //Test public and private keys
        System.out.println("Private and public keys:");
        System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
        System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
        //Create a test transaction from WalletA to walletB
        Transactions transaction = new Transactions(walletA.publicKey, walletB.publicKey, 5, null);
        transaction.generateSignature(walletA.privateKey);
        //Verify the signature works and verify it from the public key
        System.out.println("Is signature verified");
        System.out.println(transaction.verifySignature());

    }
}
