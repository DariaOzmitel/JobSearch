package com.example.ui.molecules.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.Text1
import com.example.ui.elements.text.TextTitle3
import com.example.ui.theme.JobSearchTheme

@Composable
internal fun CompanyCard(
    modifier: Modifier = Modifier,
    company: String,
    address: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(JobSearchTheme.colors.basicGrey1, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextTitle3(
                    modifier = Modifier.padding(end = 8.dp),
                    text = company,
                    color = JobSearchTheme.colors.basicWhite
                )
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.verified_company),
                    contentDescription = ""
                )
            }
            Image(painter = painterResource(id = R.drawable.map_example), contentDescription = "")
            Text1(text = address, color = JobSearchTheme.colors.basicWhite)
        }
    }
}

@Preview
@Composable
private fun CompanyCardPreview() {
    CompanyCard(company = "Мобирикс", address = "Минск, улица Бирюзова, 4/5")
}