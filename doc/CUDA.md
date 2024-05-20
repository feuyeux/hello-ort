# CUDA

<https://en.wikipedia.org/wiki/CUDA>

## 1 Compute Capability (CUDA SDK support vs. Microarchitecture)

| CUDA SDK | 1 [Tesla](https://en.wikipedia.org/wiki/Tesla_(microarchitecture)) | 2 [Fermi](https://en.wikipedia.org/wiki/Fermi_(microarchitecture)) | 3 [Kepler](https://en.wikipedia.org/wiki/Kepler_(microarchitecture))(Early) | [Kepler](https://en.wikipedia.org/wiki/Kepler_(microarchitecture))(Late) | 4 [Maxwell](https://en.wikipedia.org/wiki/Maxwell_(microarchitecture)) | 5 [Pascal](https://en.wikipedia.org/wiki/Pascal_(microarchitecture)) | 6 [Volta](https://en.wikipedia.org/wiki/Volta_(microarchitecture)) | 7 [Turing](https://en.wikipedia.org/wiki/Turing_(microarchitecture)) | 8 [Ampere](https://en.wikipedia.org/wiki/Ampere_(microarchitecture)) | 9 [Ada Lovelace](https://en.wikipedia.org/wiki/Ada_Lovelace_(microarchitecture)) | 10 [Hopper](https://en.wikipedia.org/wiki/Hopper_(microarchitecture)) | 11 [Blackwell](https://en.wikipedia.org/wiki/Blackwell_(microarchitecture)) |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
|  | [特斯拉](https://zh.wikipedia.org/wiki/%E5%B0%BC%E5%8F%A4%E6%8B%89%C2%B7%E7%89%B9%E6%96%AF%E6%8B%89) | [费米](https://zh.wikipedia.org/wiki/%E6%81%A9%E9%87%8C%E7%A7%91%C2%B7%E8%B4%B9%E7%B1%B3) | [开普勒](https://zh.wikipedia.org/wiki/%E7%BA%A6%E7%BF%B0%E5%86%85%E6%96%AF%C2%B7%E5%BC%80%E6%99%AE%E5%8B%92) | 开普勒 | [麦克斯韦](https://zh.wikipedia.org/wiki/%E8%A9%B9%E5%A7%86%E6%96%AF%C2%B7%E5%85%8B%E6%8B%89%E5%85%8B%C2%B7%E9%BA%A6%E5%85%8B%E6%96%AF%E9%9F%A6) | [帕斯卡](https://zh.wikipedia.org/wiki/%E5%B8%83%E8%8E%B1%E5%85%B9%C2%B7%E5%B8%95%E6%96%AF%E5%8D%A1) | [伏打](https://zh.wikipedia.org/wiki/%E4%BA%9E%E6%AD%B7%E5%B1%B1%E5%BE%B7%E7%BE%85%C2%B7%E4%BC%8F%E6%89%93) | [图灵](https://zh.wikipedia.org/wiki/%E8%89%BE%E4%BC%A6%C2%B7%E5%9B%BE%E7%81%B5) | [安培](https://zh.wikipedia.org/wiki/%E5%AE%89%E5%BE%B7%E7%83%88-%E9%A6%AC%E9%87%8C%C2%B7%E5%AE%89%E5%9F%B9) | [阿达·洛芙莱斯](https://zh.wikipedia.org/wiki/%E5%AE%89%E5%BE%B7%E7%83%88-%E9%A6%AC%E9%87%8C%C2%B7%E5%AE%89%E5%9F%B9) | [格蕾丝·赫柏](https://zh.wikipedia.org/wiki/%E8%91%9B%E9%BA%97%E7%B5%B2%C2%B7%E9%9C%8D%E6%99%AE) | [戴维·布莱克维尔](https://zh.wikipedia.org/wiki/%E6%88%B4%E7%BB%B4%C2%B7%E5%B8%83%E8%8E%B1%E5%85%8B%E9%9F%A6%E5%B0%94) |
| **1.0** | **1.0 – 1.1** | | | | | | | | | | | |
| **1.1** | **1.0 – 1.1+x** | | | | | | | | | | | |
| **2.0** | **1.0 – 1.1+x** | | | | | | | | | | | |
| **2.1 – 2.3.1** | **1.0 – 1.3** | | | | | | | | | | | |
| **3.0 – 3.1** | **1.0** | **2.0** | | | | | | | | | | |
| **3.2** | **1.0** | **2.1** | | | | | | | | | | |
| **4.0 – 4.2** | **1.0** | **2.1** | | | | | | | | | | |
| **5.0 – 5.5** | **1.0** | | | **3.5** | | | | | | | | |
| **6.0** | **1.0** | | **3.2** | **3.5** | | | | | | | | |
| **6.5** | **1.1** | | | **3.7** | **5.x** | | | | | | | |
| **7.0 – 7.5** | | **2.0** | | | **5.x** | | | | | | | |
| **8.0** | | **2.0** | | | | **6.x** | | | | | | |
| **9.0 – 9.2** | | | **3.0** | | | | **7.0 – 7.2** | | | | | |
| **10.0 – 10.2** | | | **3.0** | | | | | **7.5** | | | | |
| **11.0** | | | | **3.5** | | | | | **8.0** | | | |
| **11.1 – 11.4** | | | | **3.5** | | | | | **8.6** | | | |
| **11.5 – 11.7.1** | | | | **3.5** | | | | | **8.7** | | | |
| **11.8** | | | | **3.5** | | | | | | **8.9** | **9.0** | |
| 12.0 – 12.4 | | | | | 5.0 | | | | | | 9.0 | |

Note: **CUDA SDK 10.2 is the last official release for macOS**, as support will not be available for macOS in newer releases.

## 2 Compute Capability, GPU semiconductors and Nvidia GPU board products

計算能力

| Compute capability (version) | [Micro- architecture](https://en.wikipedia.org/wiki/Microarchitecture) | GPUs | [GeForce](https://en.wikipedia.org/wiki/GeForce) | [Quadro](https://en.wikipedia.org/wiki/Quadro), [NVS](https://en.wikipedia.org/wiki/Quadro#For_business_NVS) | [Tesla/Datacenter](https://en.wikipedia.org/wiki/Nvidia_Tesla) | [Tegra](https://en.wikipedia.org/wiki/Tegra), [Jetson](https://en.wikipedia.org/wiki/Nvidia_Jetson), [DRIVE](https://en.wikipedia.org/wiki/Nvidia_Drive) |
| :--------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| 1.0 | [Tesla](https://en.wikipedia.org/wiki/Tesla_(microarchitecture)) | G80 | GeForce 8800 Ultra, GeForce 8800 GTX, GeForce 8800 GTS(G80) | Quadro FX 5600, Quadro FX 4600, Quadro Plex 2100 S4 | Tesla C870, Tesla D870, Tesla S870 | |
| 1.1 | |G92, G94, G96, G98, G84, G86 | GeForce GTS 250, GeForce 9800 GX2, GeForce 9800 GTX, GeForce 9800 GT, GeForce 8800 GTS(G92), GeForce 8800 GT, GeForce 9600 GT, GeForce 9500 GT, GeForce 9400 GT, GeForce 8600 GTS, GeForce 8600 GT, GeForce 8500 GT, GeForce G110M, GeForce 9300M GS, GeForce 9200M GS, GeForce 9100M G, GeForce 8400M GT, GeForce G105M | Quadro FX 4700 X2, Quadro FX 3700, Quadro FX 1800, Quadro FX 1700, Quadro FX 580, Quadro FX 570, Quadro FX 470, Quadro FX 380, Quadro FX 370, Quadro FX 370 Low Profile, Quadro NVS 450, Quadro NVS 420, Quadro NVS 290, Quadro NVS 295, Quadro Plex 2100 D4, Quadro FX 3800M, Quadro FX 3700M, Quadro FX 3600M, Quadro FX 2800M, Quadro FX 2700M, Quadro FX 1700M, Quadro FX 1600M, Quadro FX 770M, Quadro FX 570M, Quadro FX 370M, Quadro FX 360M, Quadro NVS 320M, Quadro NVS 160M, Quadro NVS 150M, Quadro NVS 140M, Quadro NVS 135M, Quadro NVS 130M, Quadro NVS 450, Quadro NVS 420,Quadro NVS 295 | | |
| 1.2 | |GT218, GT216, GT215 | GeForce GT 340*, GeForce GT 330*, GeForce GT 320*, GeForce 315*, GeForce 310*, GeForce GT 240, GeForce GT 220, GeForce 210, GeForce GTS 360M, GeForce GTS 350M, GeForce GT 335M, GeForce GT 330M, GeForce GT 325M, GeForce GT 240M, GeForce G210M, GeForce 310M, GeForce 305M | Quadro FX 380 Low Profile, Quadro FX 1800M, Quadro FX 880M, Quadro FX 380M, Nvidia NVS 300, NVS 5100M, NVS 3100M, NVS 2100M, ION | | |
| 1.3 | |GT200, GT200b | GeForce GTX 295, GTX 285, GTX 280, GeForce GTX 275, GeForce GTX 260 | Quadro FX 5800, Quadro FX 4800, Quadro FX 4800 for Mac, Quadro FX 3800, Quadro CX, Quadro Plex 2200 D2 | Tesla C1060, Tesla S1070, Tesla M1060 | |
| 2.0 | [Fermi](https://en.wikipedia.org/wiki/Fermi_(microarchitecture)) | GF100, GF110 | GeForce GTX 590, GeForce GTX 580, GeForce GTX 570, GeForce GTX 480, GeForce GTX 470, GeForce GTX 465, GeForce GTX 480M | Quadro 6000, Quadro 5000, Quadro 4000, Quadro 4000 for Mac, Quadro Plex 7000, Quadro 5010M, Quadro 5000M | Tesla C2075, Tesla C2050/C2070, Tesla M2050/M2070/M2075/M2090 | |
| 2.1 | |GF104, GF106 GF108, GF114, GF116, GF117, GF119 | GeForce GTX 560 Ti, GeForce GTX 550 Ti, GeForce GTX 460, GeForce GTS 450, GeForce GTS 450*, GeForce GT 640 (GDDR3), GeForce GT 630, GeForce GT 620, GeForce GT 610, GeForce GT 520, GeForce GT 440, GeForce GT 440*, GeForce GT 430, GeForce GT 430*, GeForce GT 420*, GeForce GTX 675M, GeForce GTX 670M, GeForce GT 635M, GeForce GT 630M, GeForce GT 625M, GeForce GT 720M, GeForce GT 620M, GeForce 710M, GeForce 610M, GeForce 820M, GeForce GTX 580M, GeForce GTX 570M, GeForce GTX 560M, GeForce GT 555M, GeForce GT 550M, GeForce GT 540M, GeForce GT 525M, GeForce GT 520MX, GeForce GT 520M, GeForce GTX 485M, GeForce GTX 470M, GeForce GTX 460M, GeForce GT 445M, GeForce GT 435M, GeForce GT 420M, GeForce GT 415M, GeForce 710M, GeForce 410M | Quadro 2000, Quadro 2000D, Quadro 600, Quadro 4000M, Quadro 3000M, Quadro 2000M, Quadro 1000M, NVS 310, NVS 315, NVS 5400M, NVS 5200M, NVS 4200M | | |
| 3.0 | [Kepler](https://en.wikipedia.org/wiki/Kepler_(microarchitecture)) | GK104, GK106, GK107 | GeForce GTX 770, GeForce GTX 760, GeForce GT 740, GeForce GTX 690, GeForce GTX 680, GeForce GTX 670, GeForce GTX 660 Ti, GeForce GTX 660, GeForce GTX 650 Ti BOOST, GeForce GTX 650 Ti, GeForce GTX 650, GeForce GTX 880M, GeForce GTX 870M, GeForce GTX 780M, GeForce GTX 770M, GeForce GTX 765M, GeForce GTX 760M, GeForce GTX 680MX, GeForce GTX 680M, GeForce GTX 675MX, GeForce GTX 670MX, GeForce GTX 660M, GeForce GT 750M, GeForce GT 650M, GeForce GT 745M, GeForce GT 645M, GeForce GT 740M, GeForce GT 730M, GeForce GT 640M, GeForce GT 640M LE, GeForce GT 735M, GeForce GT 730M | Quadro K5000, Quadro K4200, Quadro K4000, Quadro K2000, Quadro K2000D, Quadro K600, Quadro K420, Quadro K500M, Quadro K510M, Quadro K610M, Quadro K1000M, Quadro K2000M, Quadro K1100M, Quadro K2100M, Quadro K3000M, Quadro K3100M, Quadro K4000M, Quadro K5000M, Quadro K4100M, Quadro K5100M, NVS 510, Quadro 410 | Tesla K10, GRID K340, GRID K520, GRID K2 | |
| 3.2 | |GK20A | | | | Tegra K1, Jetson TK1 |
| 3.5 | |GK110, GK208 | GeForce GTX Titan Z, GeForce GTX Titan Black, GeForce GTX Titan, GeForce GTX 780 Ti, GeForce GTX 780, GeForce GT 640 (GDDR5), GeForce GT 630 v2, GeForce GT 730, GeForce GT 720, GeForce GT 710, GeForce GT 740M (64-bit, DDR3), GeForce GT 920M | Quadro K6000, Quadro K5200 | Tesla K40, Tesla K20x, Tesla K20 | |
| 3.7 | |GK210 | | | Tesla K80 | |
| 5.0 | [Maxwell](https://en.wikipedia.org/wiki/Maxwell_(microarchitecture)) | GM107, GM108 | GeForce GTX 750 Ti, GeForce GTX 750, GeForce GTX 960M, GeForce GTX 950M, GeForce 940M, GeForce 930M, GeForce GTX 860M, GeForce GTX 850M, GeForce 845M, GeForce 840M, GeForce 830M | Quadro K1200, Quadro K2200, Quadro K620, Quadro M2000M, Quadro M1000M, Quadro M600M, Quadro K620M, NVS 810 | Tesla M10 | |
| 5.2 | |GM200, GM204, GM206 | GeForce GTX Titan X, GeForce GTX 980 Ti, GeForce GTX 980, GeForce GTX 970, GeForce GTX 960, GeForce GTX 950, GeForce GTX 750 SE, GeForce GTX 980M, GeForce GTX 970M, GeForce GTX 965M | Quadro M6000 24GB, Quadro M6000, Quadro M5000, Quadro M4000, Quadro M2000, Quadro M5500, Quadro M5000M, Quadro M4000M, Quadro M3000M | Tesla M4, Tesla M40, Tesla M6, Tesla M60 | |
| 5.3 | |GM20B | | | | Tegra X1, Jetson TX1, Jetson Nano, DRIVE CX, DRIVE PX |
| 6.0 | [Pascal](https://en.wikipedia.org/wiki/Pascal_(microarchitecture)) | GP100 | | Quadro GP100 | Tesla P100 | |
| 6.1 | |GP102, GP104, GP106, GP107, GP108 | Nvidia TITAN Xp, Titan X, GeForce GTX 1080 Ti, GTX 1080, GTX 1070 Ti, **GTX** **1070**, GTX 1060, GTX 1050 Ti, GTX 1050, GT 1030, GT 1010, MX350, MX330, MX250, MX230, MX150, MX130, MX110 | Quadro P6000, Quadro P5000, Quadro P4000, Quadro P2200, Quadro P2000, Quadro P1000, Quadro P400, Quadro P500, Quadro P520, Quadro P600, Quadro P5000(Mobile), Quadro P4000(Mobile), Quadro P3000(Mobile) | Tesla P40, Tesla P6, Tesla P4 | |
| 6.2 || GP10B | | | | Tegra X2, Jetson TX2, DRIVE PX 2 |
| 7.0 | [Volta](https://en.wikipedia.org/wiki/Volta_(microarchitecture)) | GV100 | NVIDIA TITAN V | Quadro GV100 | Tesla V100, Tesla V100S | |
| 7.2 || GV10 BGV11B | | | | Tegra Xavier, Jetson Xavier NX, Jetson AGX Xavier, DRIVE AGX Xavier, DRIVE AGX Pegasus, Clara AGX |
| 7.5 | [Turing](https://en.wikipedia.org/wiki/Turing_(microarchitecture)) | TU102, TU104, TU106, TU116, TU117 | NVIDIA TITAN RTX, GeForce RTX 2080 Ti, RTX 2080 Super, RTX 2080, RTX 2070 Super, RTX 2070, RTX 2060 Super, RTX 2060 12GB, RTX 2060, GeForce GTX 1660 Ti, GTX 1660 Super, GTX 1660, GTX 1650 Super, GTX 1650, MX550, MX450 | Quadro RTX 8000, Quadro RTX 6000, Quadro RTX 5000, Quadro RTX 4000, T1000, T600, T400 T1200(mobile), T600(mobile), T500(mobile), Quadro T2000(mobile), Quadro T1000(mobile) | **Tesla T4** | |
| 8.0 | [Ampere](https://en.wikipedia.org/wiki/Ampere_(microarchitecture)) | GA100 | | | A100 80GB, A100 40GB, A30 | |
| 8.6 | |GA102, GA103, GA104, GA106, GA107 | GeForce RTX 3090 Ti, RTX 3090, RTX 3080 Ti, RTX 3080 12GB, RTX 3080, RTX 3070 Ti, RTX 3070, RTX 3060 Ti, RTX 3060, RTX 3050, RTX 3050 Ti(mobile), RTX 3050(mobile), RTX 2050(mobile), MX570 | RTX A6000, RTX A5500, RTX A5000, RTX A4500, RTX A4000, RTX A2000 RTX A5000(mobile), RTX A4000(mobile), RTX A3000(mobile), RTX A2000(mobile) | A40, A16, A10, A2 | |
| 8.7 || GA10B | | | | Jetson Orin Nano, Jetson Orin NX, Jetson AGX Orin, DRIVE AGX Orin, DRIVE AGX Pegasus OA, Clara Holoscan |
| 8.9 | [Ada Lovelace](https://en.wikipedia.org/wiki/Ada_Lovelace_(microarchitecture)) | AD102, AD103, AD104, AD106, AD107 | **GeForce RTX 4090**, RTX 4080 Super, RTX 4080, RTX 4070 Ti Super, RTX 4070 Ti, RTX 4070 Super, RTX 4070, RTX 4060 Ti, RTX 4060 | RTX 6000 Ada, RTX 5880 Ada, RTX 5000 Ada, RTX 4500 Ada, RTX 4000 Ada, RTX 4000 SFF | L40S, L40, L20, L4, L2 | |
| 9.0 | [Hopper](https://en.wikipedia.org/wiki/Hopper_(microarchitecture)) | GH100 | | | H200, **H100** | |
| 10.0 | [Blackwell](https://en.wikipedia.org/wiki/Blackwell_(microarchitecture)) | GB100 | | | B200, B100 | |
| 10.x | [Blackwell](https://en.wikipedia.org/wiki/Blackwell_(microarchitecture)) | GB202, GB203, GB205, GB206, GB207 | RTX 5090, RTX5080 | | B40 | |
| **Compute capability (version)** | **[Micro- architecture](https://en.wikipedia.org/wiki/Microarchitecture)** | **GPUs** | **[GeForce](https://en.wikipedia.org/wiki/GeForce)** | **[Quadro](https://en.wikipedia.org/wiki/Quadro), [NVS](https://en.wikipedia.org/wiki/Quadro#For_business_NVS)** | **[Tesla/Datacenter](https://en.wikipedia.org/wiki/Nvidia_Tesla)** | **[Tegra](https://en.wikipedia.org/wiki/Tegra), [Jetson](https://en.wikipedia.org/wiki/Nvidia_Jetson), [DRIVE](https://en.wikipedia.org/wiki/Nvidia_Drive)** |

'*' – [OEM](https://en.wikipedia.org/wiki/Original_equipment_manufacturer)-only products

## 3 Product board series

1. **Desktop**
   - GeForce series
   - RTX series
2. **Workstation**
   - Quadro series
   - Quadro NVS series
3. **Data Center**
   - Tesla series
4. **Mobile**
   - Tegra series
5. **Embedded Computing**
   - Jetson series
6. **Autonomous car and driver assistance**
   - Drive series

### Nvidia Drive

https://en.wikipedia.org/wiki/Nvidia_Drive

| Drive            | MicroArchitecture |
| ---------------- | ----------------- |
| Drive CX         | Maxwell           |
| Drive PX         | Maxwell           |
| Drive PX 2       | Pascal            |
| Drive PX Xavier  | Volta             |
| Drive PX Pegasus | Volta, Turing|
| Drive AGX Orin | Ampere |
| DRIVE Thor | Blackwell |

