package com.bnyro.contacts.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bnyro.contacts.obj.ContactData
import com.bnyro.contacts.ui.components.ContactEntry
import com.bnyro.contacts.ui.components.base.FullScreenDialog

@Composable
fun SingleContactScreen(contact: ContactData, onClose: () -> Unit) {
    FullScreenDialog(onClose = onClose) {
        val scrollState = rememberScrollState()
        val shape = RoundedCornerShape(20.dp)

        Column(
            modifier = Modifier.verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth()
                    .clip(shape),
                shape = shape
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 50.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(135.dp)
                            .background(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary
                            )
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = (contact.displayName?.firstOrNull() ?: "").toString(),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 65.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = contact.displayName.orEmpty(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            contact.phoneNumber.forEach {
                ContactEntry(label = "Phone", content = it) {
                }
            }
        }
    }
}