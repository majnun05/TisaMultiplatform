package com.badista.tisakmp.android.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.badista.tisakmp.android.R
import com.badista.tisakmp.android.common.theming.Black33
import com.badista.tisakmp.android.common.theming.Grey82
import com.badista.tisakmp.android.common.theming.GreyE0
import com.badista.tisakmp.android.common.theming.MainColor
import com.badista.tisakmp.android.common.theming.MavenBold
import com.badista.tisakmp.android.common.theming.MavenReguler
import com.badista.tisakmp.android.common.theming.Turquoise

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            TopAppBar()
            CardProfile()
            PerformaHariIni()
            BoxPerforma()
            Pengumuman()
        }
    }
}

@Composable
fun TopAppBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, GreyE0)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = R.drawable.img_logo_login),
                contentDescription = "logo"
            )

            Spacer(modifier = Modifier.padding(start = 6.dp))

            Text(
                text = "Topindoku Internal Sales App",
                color = Color.Black,
                fontFamily = MavenBold,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )

            Image(
                modifier = Modifier.size(26.dp).weight(1f),
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "logo",
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Composable
fun CardProfile(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 20.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Turquoise
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            Text(
                text = "Malik Alkatiri",
                fontSize = 16.sp,
                fontFamily = MavenBold,
                fontWeight = FontWeight(500)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
               Image(
                   painter = painterResource(id = R.drawable.ic_marker_red),
                   contentDescription = null,
                   modifier = Modifier.size(12.dp)
               )

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                Text(
                    text = "Sambas",
                    fontSize = 14.sp,
                    fontFamily = MavenBold,
                    fontWeight = FontWeight(500),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                Text(
                    text = "|",
                    fontSize = 14.sp,
                    fontFamily = MavenBold,
                    fontWeight = FontWeight(500),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                Text(
                    text = "TS88217312",
                    fontSize = 14.sp,
                    fontFamily = MavenBold,
                    fontWeight = FontWeight(500),
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun PerformaHariIni() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, GreyE0)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Performa Hari Ini",
                fontSize = 16.sp,
                fontFamily = MavenBold,
                fontWeight = FontWeight.Bold,
                color = Black33
            )

            Text(
                modifier = Modifier.weight(1f),
                text = "Lihat Semua",
                fontSize = 14.sp,
                fontFamily = MavenReguler,
                fontWeight = FontWeight.Bold,
                color = MainColor,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun BoxPerforma() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // baris 1
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // jumlah saldo
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_total_price),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Jumlah Saldo",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Text(
                            text = "Rp. 12.000.000",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Bold,
                            color = Black33
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

            // deposite mitra
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_deposit_partners),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Deposit Mitra",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Text(
                            text = "Rp. 5.000.000",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Bold,
                            color = Black33
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

        }

        // baris 2
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // visit mitra
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_user_visits),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Visit Mitra",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Row {
                            Text(
                                text = "30",
                                fontSize = 14.sp,
                                fontFamily = MavenBold,
                                fontWeight = FontWeight.Bold,
                                color = Black33
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = "Agen",
                                fontSize = 14.sp,
                                fontFamily = MavenReguler,
                                fontWeight = FontWeight.Medium,
                                color = Grey82
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

            // mitra baru
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_person_visit_centang),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Mitra Baru",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Row {
                            Text(
                                text = "10",
                                fontSize = 14.sp,
                                fontFamily = MavenBold,
                                fontWeight = FontWeight.Bold,
                                color = Black33
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = "Agen",
                                fontSize = 14.sp,
                                fontFamily = MavenReguler,
                                fontWeight = FontWeight.Medium,
                                color = Grey82
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

        }

        // baris 3
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // visit prospek
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_person_loc),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Visit Prospek",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Row {
                            Text(
                                text = "30",
                                fontSize = 14.sp,
                                fontFamily = MavenBold,
                                fontWeight = FontWeight.Bold,
                                color = Black33
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = "Agen",
                                fontSize = 14.sp,
                                fontFamily = MavenReguler,
                                fontWeight = FontWeight.Medium,
                                color = Grey82
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

            // prospek baru
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, GreyE0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_person_centang),
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Prospek Baru",
                            fontSize = 14.sp,
                            fontFamily = MavenBold,
                            fontWeight = FontWeight.Medium,
                            color = Grey82
                        )

                        Row {
                            Text(
                                text = "10",
                                fontSize = 14.sp,
                                fontFamily = MavenBold,
                                fontWeight = FontWeight.Bold,
                                color = Black33
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = "Agen",
                                fontSize = 14.sp,
                                fontFamily = MavenReguler,
                                fontWeight = FontWeight.Medium,
                                color = Grey82
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_card_home),
                        contentDescription = null,
                        alignment = Alignment.CenterEnd
                    )
                }
            }

        }
    }
}

@Composable
fun Pengumuman() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, GreyE0)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Pengumuman",
                fontSize = 16.sp,
                fontFamily = MavenBold,
                fontWeight = FontWeight.Bold,
                color = Black33
            )

            Text(
                modifier = Modifier.weight(1f),
                text = "Lihat Semua",
                fontSize = 14.sp,
                fontFamily = MavenReguler,
                fontWeight = FontWeight.Bold,
                color = MainColor,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}