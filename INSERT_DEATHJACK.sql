USE DEATHJACK;

INSERT player (id, NAME, bot) VALUES (1, "CROUPIER", TRUE);

INSERT cards VALUES (1, "sA");
INSERT cards VALUES (2, "s2");
INSERT cards VALUES (3, "s3");
INSERT cards VALUES (4, "s4");
INSERT cards VALUES (5, "s5");
INSERT cards VALUES (6, "s6");
INSERT cards VALUES (7, "s7");
INSERT cards VALUES (8, "s8");
INSERT cards VALUES (9, "s9");
INSERT cards VALUES (10, "s10");
INSERT cards VALUES (11, "sJ");
INSERT cards VALUES (12, "sQ");
INSERT cards VALUES (13, "sK");

INSERT cards VALUES (14, "gcA");
INSERT cards VALUES (15, "gc2");
INSERT cards VALUES (16, "gc3");
INSERT cards VALUES (17, "gc4");
INSERT cards VALUES (18, "gc5");
INSERT cards VALUES (19, "gc6");
INSERT cards VALUES (20, "gc7");
INSERT cards VALUES (21, "gc8");
INSERT cards VALUES (22, "gc9");
INSERT cards VALUES (23, "gc10");
INSERT cards VALUES (24, "gcJ");
INSERT cards VALUES (25, "gcQ");
INSERT cards VALUES (26, "gcK");

INSERT cards VALUES (27, "dA");
INSERT cards VALUES (28, "d2");
INSERT cards VALUES (29, "d3");
INSERT cards VALUES (30, "d4");
INSERT cards VALUES (31, "d5");
INSERT cards VALUES (32, "d6");
INSERT cards VALUES (33, "d7");
INSERT cards VALUES (34, "d8");
INSERT cards VALUES (35, "d9");
INSERT cards VALUES (36, "d10");
INSERT cards VALUES (37, "dJ");
INSERT cards VALUES (38, "dQ");
INSERT cards VALUES (39, "dK");

INSERT cards VALUES (40, "hA");
INSERT cards VALUES (41, "h2");
INSERT cards VALUES (42, "h3");
INSERT cards VALUES (43, "h4");
INSERT cards VALUES (44, "h5");
INSERT cards VALUES (45, "h6");
INSERT cards VALUES (46, "h7");
INSERT cards VALUES (47, "h8");
INSERT cards VALUES (48, "h9");
INSERT cards VALUES (49, "h10");
INSERT cards VALUES (50, "hJ");
INSERT cards VALUES (51, "hQ");
INSERT cards VALUES (52, "hK");

INSERT object VALUES (1, "CHANGE!", "Change your hand to the opponent");
INSERT object VALUES (2, "SHOTGUN", "Shoot your opponent and he lost 1 hp");
INSERT object VALUES (3, "THIEF", "Draw one card to the opponent's hand");
INSERT object VALUES (4, "COOKIE", "Eat a cookie gains 1 hp");
INSERT object VALUES (5, "TRY AGAIN!", "Discard one card from your hand and draw other card");
INSERT object VALUES (6, "GUARDIAN ANGEL", "If you lost 'x' hp, you gain this 'x' hp");
