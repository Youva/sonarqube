/*
 * SonarQube
 * Copyright (C) 2009-2024 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
import { isPullRequest } from '../../helpers/branch-like';

import { Branch, BranchLike, BranchParameters, MainBranch } from '../../types/branch-like';

export function getBranchLikeQuery(
  branchLike?: BranchLike,
  includeMainBranch = false,
): BranchParameters {
  if (isBranch(branchLike) && (includeMainBranch || !isMainBranch(branchLike))) {
    return { branch: branchLike.name };
  } else if (isPullRequest(branchLike)) {
    return { pullRequest: branchLike.key };
  }
  return {};
}
export function isBranch(branchLike?: BranchLike): branchLike is Branch {
  return branchLike !== undefined && (branchLike as Branch).isMain !== undefined;
}
export function isMainBranch(branchLike?: BranchLike): branchLike is MainBranch {
  return isBranch(branchLike) && branchLike.isMain;
}
