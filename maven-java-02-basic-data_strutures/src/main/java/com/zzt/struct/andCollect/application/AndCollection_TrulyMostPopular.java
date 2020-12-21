package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 描述：<br>面试题 17.07. 婴儿名字
 https://leetcode-cn.com/problems/baby-names-lcci/
 </>
 @author zzt */
public class AndCollection_TrulyMostPopular {

    @Test
    public void test01() {
        String[] names = {"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)"
                , "Wzyyim(34)", "Bnea(55)", "Kri(71)", "Qnaakk(76)", "Gnplfi(68)", "Hfp(97)", "Qoi(70)"
                , "Ijveol(46)", "Iidh(64)", "Qiy(26)", "Mcnef(59)", "Hvueqc(91)", "Obcbxb(54)", "Dhe(79)"
                , "Jfq(26)", "Uwjsu(41)", "Wfmspz(39)", "Ebov(96)", "Ofl(72)", "Uvkdpn(71)", "Avcp(41)"
                , "Msyr(9)", "Pgfpma(95)", "Vbp(89)", "Koaak(53)", "Qyqifg(85)", "Dwayf(97)", "Oltadg(95)"
                , "Mwwvj(70)", "Uxf(74)", "Qvjp(6)", "Grqrg(81)", "Naf(3)", "Xjjol(62)", "Ibink(32)", "Qxabri(41)"
                , "Ucqh(51)", "Mtz(72)", "Aeax(82)", "Kxutz(5)", "Qweye(15)", "Ard(82)", "Chycnm(4)", "Hcvcgc(97)"
                , "Knpuq(61)", "Yeekgc(11)", "Ntfr(70)", "Lucf(62)", "Uhsg(23)", "Csh(39)", "Txixz(87)", "Kgabb(80)"
                , "Weusps(79)", "Nuq(61)", "Drzsnw(87)", "Xxmsn(98)", "Onnev(77)", "Owh(64)", "Fpaf(46)", "Hvia(6)"
                , "Kufa(95)", "Chhmx(66)", "Avmzs(39)", "Okwuq(96)", "Hrschk(30)", "Ffwni(67)", "Wpagta(25)", "Npilye(14)"
                , "Axwtno(57)", "Qxkjt(31)", "Dwifi(51)", "Kasgmw(95)", "Vgxj(11)", "Nsgbth(26)", "Nzaz(51)", "Owk(87)"
                , "Yjc(94)", "Hljt(21)", "Jvqg(47)", "Alrksy(69)", "Tlv(95)", "Acohsf(86)", "Qejo(60)", "Gbclj(20)", "Nekuam(17)"
                , "Meutux(64)", "Tuvzkd(85)", "Fvkhz(98)", "Rngl(12)", "Gbkq(77)", "Uzgx(65)", "Ghc(15)", "Qsc(48)", "Siv(47)"};
        String[] synonyms = {"(Gnplfi,Qxabri)", "(Uzgx,Siv)", "(Bnea,Lucf)", "(Qnaakk,Msyr)", "(Grqrg,Gbclj)", "(Uhsg,Qejo)"
                , "(Csh,Wpagta)", "(Xjjol,Lucf)", "(Qoi,Obcbxb)", "(Npilye,Vgxj)", "(Aeax,Ghc)", "(Txixz,Ffwni)", "(Qweye,Qsc)"
                , "(Kri,Tuvzkd)", "(Ommjh,Vbp)", "(Pgfpma,Xxmsn)", "(Uhsg,Csh)", "(Qvjp,Kxutz)", "(Qxkjt,Tlv)", "(Wfmspz,Owk)"
                , "(Dwayf,Chycnm)", "(Iidh,Qvjp)", "(Dnsay,Rngl)", "(Qweye,Tlv)", "(Wzyyim,Kxutz)", "(Hvueqc,Qejo)", "(Tlv,Ghc)"
                , "(Hvia,Fvkhz)", "(Msyr,Owk)", "(Hrschk,Hljt)", "(Owh,Gbclj)", "(Dwifi,Uzgx)", "(Iidh,Fpaf)", "(Iidh,Meutux)"
                , "(Txixz,Ghc)", "(Gbclj,Qsc)", "(Kgabb,Tuvzkd)", "(Uwjsu,Grqrg)", "(Vbp,Dwayf)", "(Xxmsn,Chhmx)", "(Uxf,Uzgx)"};
        String[] popular = trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(popular));
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        AndCollection collection = new AndCollection();
        for (String synonym : synonyms) {
            String[] str = turnSynonym(synonym);
            collection.addNode(str[0]);
            collection.addNode(str[1]);
            collection.union(str[0], str[1]);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            Info info = turnDate(name);
            collection.addNode(info.name);
            String fatherName = collection.findFather(info.name);
            map.put(fatherName, map.getOrDefault(fatherName, 0) + info.count);
        }
        String[] result = new String[map.size()];
        AtomicInteger i = new AtomicInteger(0);
        map.forEach((k, v) -> result[i.getAndIncrement()] = k + "(" + v + ")");
        return result;
    }

    private static class AndCollection {
        Map<String, String> parentMap;
        Set<String> set;

        public AndCollection() {
            parentMap = new HashMap<>();
            set = new HashSet<>();
        }

        public void addNode(String synonym) {
            if (set.add(synonym)) {
                parentMap.put(synonym, synonym);
            }
        }

        public void union(String a, String b) {
            String aInfo = findFather(a);
            String bInfo = findFather(b);
            if (!aInfo.equals(bInfo)) {
                parentMap.put(bInfo, aInfo);
            }
        }

        public String findFather(String name) {
            Stack<String> stack = new Stack<>();
            String help;
            while (!(help = parentMap.get(name)).equals(name)) {
                stack.push(help);
                name = help;
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), help);
            }
            return help;
        }

    }

    private Info turnDate(String name) {
        int last = name.length() - 1;
        int left = last;
        while (name.charAt(left) != '(') {
            left--;
        }
        String count = name.substring(left + 1, last);
        name = name.substring(0, left);
        return new Info(name, Integer.parseInt(count));
    }

    private String[] turnSynonym(String synonym) {
        String[] synonyms = new String[2];
        int i = synonym.indexOf(",");
        synonyms[0] = synonym.substring(1, i);
        synonyms[1] = synonym.substring(i + 1, synonym.length() - 1);
        return synonyms;
    }

    private static class Info {
        String name;
        int count;

        public Info() {
        }

        public Info(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
