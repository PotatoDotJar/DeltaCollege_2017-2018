import java.util.Random;

public class Main {

	static double[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][] array = 
			new double[255][255][255][255][255][255][255][255][255][255][255][255][255][255][255][255][255]
					[255][255][255][255][255][255][255][255][255][255][255][255][255];

	public static void main(String[] args) {

		Random rand = new Random();

		for(int a = 0; a < 255; a++) {
			for(int b = 0; b < 255; b++) {
				for(int c = 0; c < 255; c++) {
					for(int d = 0; d < 255; d++) {
						for(int e = 0; e < 255; e++) {
							for(int f = 0; f < 255; f++) {
								for(int g = 0; g < 255; g++) {
									for(int h = 0; h < 255; h++) {
										for(int i = 0; i < 255; i++) {
											for(int j = 0; j < 255; j++) {
												for(int k = 0; k < 255; k++) {
													for(int l = 0; l < 255; l++) {
														for(int m = 0; m < 255; m++) {
															for(int n = 0; n < 255; n++) {
																for(int o = 0; o < 255; o++) {
																	for(int p = 0; p < 255; p++) {
																		for(int q = 0; q < 255; q++) {
																			for(int r = 0; r < 255; r++) {
																				for(int s = 0; s < 255; s++) {
																					for(int t = 0; t < 255; t++) {
																						for(int u = 0; u < 255; u++) {
																							for(int v = 0; v < 255; v++) {
																								for(int w = 0; w < 255; w++) {
																									for(int x = 0; x < 255; x++) {
																										for(int y = 0; y < 255; y++) {
																											for(int z = 0; z < 255; z++) {
																												for(int aa = 0; aa < 255; aa++) {
																													for(int bb = 0; bb < 255; bb++) {
																														for(int cc = 0; cc < 255; cc++) {
																															for(int dd = 0; dd < 255; dd++) {
																																array[a][b][c][d][e][f][g][h][i][j][k][l][m][n]
																																		[o][p][q][r][s][t][u][v][w][x][y][z][aa][bb][cc][dd] = rand.nextDouble();
																															}
																														}
																													}
																												}
																											}

																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}

																}
															}
														}
													}
												}
											}
										}
									}
								}
							}

						}
					}
				}
			}
		}
	}


}

